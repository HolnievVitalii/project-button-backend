package com.button.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "product_property")
public class ProductProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_list_id", referencedColumnName = "id")
    private ProductList productList;

    private Float quantity;

    private Boolean state;

    private String units;

    public ProductProperty() {
        quantity = 0.0f;
        state = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonProperty("product_id")
    public void setProductId(Integer productId) {
        product = new Product();
        product.setId(productId);
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    @JsonProperty("product_list_id")
    public void setProductListId(Integer productListId) {
        productList = new ProductList();
        productList.setId(productListId);
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String toString() {
        return String.format("ProductProperty: %d %s %s %f %b %s",
                this.id, this.product.getName(), this.productList.getName(), this.quantity, this.state, this.units);
    }
}
