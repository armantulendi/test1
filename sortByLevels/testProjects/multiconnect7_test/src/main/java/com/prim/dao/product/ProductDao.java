package com.prim.dao.product;

import com.prim.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product,Long> {
    @Override
    Iterable<Product> findAll();
}
