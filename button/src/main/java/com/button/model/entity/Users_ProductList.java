package com.button.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users_product_list")
public class Users_ProductList implements Serializable {

//    @Id
//    @Column(name = "user_id")
//    private Integer userId;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

//    @Id
//    @Column(name = "product_list_id")
//    private Integer productListId;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_list_id", referencedColumnName = "id")
    private ProductList productList;

    public Users_ProductList() {}

    public Users_ProductList(User _user, ProductList _productList) {
        user = _user;
        productList = _productList;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Integer getProductListId() {
//        return productListId;
//    }
//
//    public void setProductListId(Integer productListId) {
//        this.productListId = productListId;
//    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Users_ProductList that = (Users_ProductList) o;
        return Objects.equals(user, that.user) && Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, productList);
    }
}
