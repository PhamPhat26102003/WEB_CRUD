package crudspring.projectcrud.service;

import crudspring.projectcrud.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll(String keyword);
    Product save(Product product);
    Product getById(Long id);
    void delete(Long id);
    Product get(Long id);
}
