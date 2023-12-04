package com.example.amdb.Service;

import com.example.amdb.Model.Merchant;
import com.example.amdb.Model.MerchantStock;
import com.example.amdb.Repository.MerchantRepository;
import com.example.amdb.Repository.MerchantStockRepository;
import com.example.amdb.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantStockRepository;
    private final MerchantRepository merchantRepository;
    private final ProductRepository productRepository;

    public List<MerchantStock> getMerchantStockService(){

        return merchantStockRepository.findAll();
    }
    public void addMerchantStock(MerchantStock merchantStock) {
        for (int i = 0; i <productRepository.findAll().size() ; i++) {
            if (merchantStock.getProductID()==productRepository.findAll().get(i).getId()) {
                for (int j = 0; j <merchantRepository.findAll().size() ; j++) {
                    if (merchantStock.getMerchantID()==merchantRepository.findAll().get(i).getId()) {
                        merchantStockRepository.save(merchantStock);
                    }

                }
            }
        }
        }
        public Boolean updateMerchantStock(Integer id ,MerchantStock merchantStock){
           MerchantStock merchantStock1 =merchantStockRepository.getById(id);
            for (int i = 0; i <productRepository.findAll().size() ; i++) {
                if (merchantStock.getProductID()==productRepository.findAll().get(i).getId()) {
                    for (int j = 0; j <merchantRepository.findAll().size() ; j++) {
                        if (merchantStock.getMerchantID()==merchantRepository.findAll().get(i).getId()) {

                           merchantStock1.setStock(merchantStock.getStock());
                           merchantStockRepository.save(merchantStock1);
                           return true;
                        }

                    }
                }
            }
            return false;
        }
        public Boolean deleteMerchantStock(Integer id){
        MerchantStock merchantStock =merchantStockRepository.getById(id);
            if (merchantStock == null) {
                return false;
            }
            merchantStockRepository.delete(merchantStock);
            return true;
        }

        }


