package crudspring.projectcrud.service.impl;

import crudspring.projectcrud.entity.Product;
import crudspring.projectcrud.repository.ProductRepository;
import crudspring.projectcrud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll(String keyword) {
        if(keyword != null){
            return productRepository.findAll(keyword);
        }
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product get(Long id) {
        return productRepository.getById(id);
    }
}
