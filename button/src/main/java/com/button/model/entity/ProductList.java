package com.button.model.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_list")
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "productList",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Users_ProductList> productListUsers = new ArrayList<>();

    @OneToMany(
            mappedBy = "productList",
            cascade = CascadeType.ALL)
    private List<ProductProperty> productProperties = new ArrayList<>();

    public ProductList() {}

    public void setId(Integer _id) {
        id = _id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void addUser(User user) {
        Users_ProductList users_productList = new Users_ProductList(user, this);
//        users_productList.setProductListId(this.id);
//        users_productList.setUserId(user.getId());
        productListUsers.add(users_productList);
        user.getProductLists().add(users_productList);

        for( Users_ProductList usr : productListUsers) {
            User usr1 = usr.getUser();
            System.out.println(usr1.getId() + " " + usr1.getLogin() + " " + usr1.getName() + " " + usr1.getSurname());
        }
    }

    public void removeUser(User user) {
        Users_ProductList users_productList = new Users_ProductList(user, this);
        productListUsers.remove(users_productList);
        user.getProductLists().remove(users_productList);

        users_productList.setUser(null);
        users_productList.setProductList(null);
    }

    public List<Users_ProductList> getProductListUsers() {
        return productListUsers;
    }
}
