package com.button.model;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductPropertyRepository extends CrudRepository<ProductProperty, Integer> {
//    @Query("SELECT pp\n" +
//            "FROM product_property pp\n" +
//            "INNER JOIN product p ON\n" +
//            "\tpp.product_id = p.id\n" +
//            "INNER JOIN product_list pl ON\n" +
//            "\tpp.product_list_id = pl.id\n" +
//            "WHERE\n" +
//            "\tpl.id = :list_id")
    @Query("SELECT pp FROM product_property pp WHERE pp.product_list_id = :list_id")
    List<ProductProperty> findProductsByProductListId(@Param("list_id") Integer listId);
}
