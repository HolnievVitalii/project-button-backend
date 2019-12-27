package com.button.model.repo;

import com.button.model.entity.ProductList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductListRepository extends CrudRepository<ProductList, Integer> {

    @Query(
            value = "SELECT pl.* " +
                    "FROM users_product_list upl " +
                    "INNER JOIN product_list pl ON" +
                    "   upl.product_list_id = pl.id " +
                    "WHERE " +
                    "   user_id = :user_id",
            nativeQuery = true
    )
    Iterable<ProductList> findProductListByUserId(@Param("user_id") Integer userId);
}
