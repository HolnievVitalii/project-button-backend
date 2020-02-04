package com.button.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;

    private String pass;

    private String name;

    private String surname;

    private boolean disabled;

    @ManyToMany(
            mappedBy = "users",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    private Set<ProductList> productLists = new HashSet<>();

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Set<ProductList> getProductLists() {
        return productLists;
    }

    public void addProductList(ProductList productList) {
        productLists.add(productList);
        productList.getUsers().add(this);
    }

    public void removeProductList(ProductList productList) {
        productLists.remove(productList);

//        Users_ProductList users_productList = new Users_ProductList(this, productList);
//        productList.getProductListUsers().remove(this);
//        productLists.remove(productList);
//
//        users_productList.setUser(null);
//        users_productList.setProductList(null);
    }
}
