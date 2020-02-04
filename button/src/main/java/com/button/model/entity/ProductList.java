package com.button.model.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product_list")
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "users_product_list",
            joinColumns = {@JoinColumn(name = "product_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> users = new HashSet<>();

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

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        user.getProductLists().add(this);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
