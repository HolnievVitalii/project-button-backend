package com.button.model;

import javax.persistence.*;

@Entity
@Table(name = "product_property")
public class ProductProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer product_id;

    @Column
    private Integer product_list_id;

    @Column
    private Float quantity;

    @Column
    private String units;

    @Column
    private Integer state;

    public ProductProperties(){}

    public Integer getId() {
        return id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public Integer getProduct_list_id() {
        return product_list_id;
    }

    public Float getQuantity() {
        return quantity;
    }

    public String getUnits() {
        return units;
    }

    public Integer getState() {
        return state;
    }
}