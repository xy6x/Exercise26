package com.example.amdb.Repository;

import com.example.amdb.Model.MerchantStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MerchantStockRepository extends JpaRepository<MerchantStock,Integer> {
}
