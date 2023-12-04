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
        for (int i = 0; i <categoryRepository.findAll().size() ; i++) {
            if (product.getCategoryID()==categoryRepository.findAll().get(i).getId()) {
            productRepository.save(product);
            }

        }

    }
    public Boolean updateProducts(Integer id ,Product product){
      Product oldproduct = productRepository.getById(id);
        for (int i = 0; i <categoryRepository.findAll().size() ; i++) {
            if (product.getCategoryID() == categoryRepository.findAll().get(i).getId()) {
                oldproduct.setName(product.getName());
                oldproduct.setPrice(product.getPrice());
                productRepository.save(oldproduct);
                return true;
            }

        }
        return false;
    }
    public Boolean deleteProducts(Integer id){
        Product product =productRepository.getById(id);
        if (product == null) {
            return false;
        }
        productRepository.delete(product);
        return true;
    }

}