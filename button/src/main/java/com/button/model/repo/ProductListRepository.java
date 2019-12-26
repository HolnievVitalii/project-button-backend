package com.button.model.repo;

import com.button.model.entity.ProductList;
import org.springframework.data.repository.CrudRepository;

public interface ProductListRepository extends CrudRepository<ProductList, Integer> {
}
