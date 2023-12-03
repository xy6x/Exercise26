package com.example.amdb.Service;

import com.example.amdb.Model.Category;
import com.example.amdb.Model.Product;
import com.example.amdb.Repository.CategoryRepository;
import com.example.amdb.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void addProducts(Product product) {
product.getCategoryID();
List<Category> category =categoryRepository.findAll();
            if (category.toArray().equals(product.getCategoryID())) {
               productRepository.save(product);
               productRepository.save(product);
            }

    }
    public boolean updateProducts(String id ,Product product){
        Category category =categoryRepository.getById(product.getId());

        if (categoryRepository.equals(product.getCategoryID().equals(id))) {
                productRepository.save(product);
                return true;
            }
        return false;
    }

}