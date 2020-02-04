package com.button.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Users_ProductList> productLists = new ArrayList<>();

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

    public List<Users_ProductList> getProductLists() {
        return productLists;
    }

    public void addProductList(ProductList productList) {
        Users_ProductList users_productList = new Users_ProductList(this, productList);
//        users_productList.setProductListId(productList.getId());
//        users_productList.setUserId(this.getId());
        productLists.add(users_productList);
        productList.getProductListUsers().add(users_productList);
    }

    public void removeProductList(ProductList productList) {
        Users_ProductList users_productList = new Users_ProductList(this, productList);
        productList.getProductListUsers().remove(this);
        productLists.remove(productList);

        users_productList.setUser(null);
        users_productList.setProductList(null);
    }
}
