package com.button.model;

import javax.persistence.*;

@Entity
@Table(name = "product_list")
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

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
}
