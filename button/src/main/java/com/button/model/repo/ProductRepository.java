package com.button.model.repo;

import com.button.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(
            value = "SELECT p.* FROM product p WHERE p.name = :name",
            nativeQuery = true
    )
    Product findProductByName(@Param("name") String name);
}
