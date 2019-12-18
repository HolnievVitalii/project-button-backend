package com.button.model;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductPropertyRepository extends CrudRepository<ProductProperty, Integer> {
    @Query(
        value = "SELECT pp.* " +
            "FROM product_property pp " +
            "WHERE " +
            "   pp.product_list_id = :list_id",
        nativeQuery = true)
    Iterable<ProductProperty> findProductsByProductListId(@Param("list_id") Integer listId);
}
