package org.example.bikeshop.dao;

import org.example.Product;

import java.sql.Connection;
import java.util.List;

public interface ProductDao {
    List<Product> getByCategory(String category);

}
