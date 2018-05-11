package services;

import models.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAll() throws ClassNotFoundException, SQLException;
}
