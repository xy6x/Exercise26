package com.example.amdb.Service;

import com.example.amdb.Model.Merchant;
import com.example.amdb.Model.MerchantStock;
import com.example.amdb.Repository.MerchantRepository;
import com.example.amdb.Repository.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantStockRepository;
    private final MerchantService merchantService;
    private final ProductService productService;
private final MerchantRepository merchantRepository;
    public List<MerchantStock> getMerchantStockService(){
        return merchantStockRepository.findAll();
    }
    public void addMerchantStock(MerchantStock merchantStock ,Integer id) {
        Merchant mer =  merchantRepository.getById(id);
        if (mer.getId().equals(merchantStockRepository.getById(id))) {
         merchantStockRepository.save(merchantStock);

        }


    }
}
