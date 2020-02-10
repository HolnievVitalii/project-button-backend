package com.button.web.controller;

import com.button.model.entity.Product;
import com.button.model.entity.ProductList;
import com.button.model.entity.ProductProperty;
import com.button.model.repo.ProductListRepository;
import com.button.model.repo.ProductPropertyRepository;
import com.button.model.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/list_products")
public class ListProductsPageController {
    @Autowired
    private ProductPropertyRepository productPropertyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductListRepository productListRepository;

    @GetMapping("/{list_id}")
    public String listProductsPage(Model model, @PathVariable("list_id") Integer listId) {
        Iterable<ProductProperty> listProducts = productPropertyRepository.findProductsByProductListId(listId);
        model.addAttribute("list_id", listId);
        model.addAttribute("listProducts", listProducts);
        return "list_products";
    }

    @GetMapping("/{list_id}/add_product")
    public String addProductPage(Model model, @PathVariable("list_id") Integer listId) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("new_product", new Product());
        model.addAttribute("list", listId);
        return "add_product";
    }

    @PostMapping("/{list_id}/add")
    public String addProductToList(@PathVariable("list_id") Integer listId,
                                   @ModelAttribute("new_product") Product newProduct)
    {

        Product product = productRepository.findProductByName(newProduct.getName());
        if (product == null) {
            product = productRepository.save(newProduct);
        }

        ProductProperty productProperty = new ProductProperty();
        productProperty.setProductId(product.getId());
        productProperty.setProductListId(listId);
        productPropertyRepository.save(productProperty);

        return "redirect:/list_products/" + listId;
    }

    @GetMapping("/{list_id}/delete/{product_property_id}")
    public String deleteProductFromList(@PathVariable("list_id") Integer listId,
                                        @PathVariable("product_property_id") Integer productPropertyId)
    {
        productPropertyRepository.deleteById(productPropertyId);
        return "redirect:/list_products/" + listId;
    }
}
