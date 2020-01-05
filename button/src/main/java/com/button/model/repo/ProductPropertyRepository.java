package com.button.model.repo;

import com.button.model.entity.ProductProperty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductPropertyRepository extends CrudRepository<ProductProperty, Integer> {
    @Query(
        value = "SELECT pp.* " +
            "FROM product_property pp " +
            "WHERE " +
            "   pp.product_list_id = :list_id",
        nativeQuery = true)
    Iterable<ProductProperty> findProductsByProductListId(@Param("list_id") Integer listId);
}
