package com.example.amdb.Repository;

import com.example.amdb.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
