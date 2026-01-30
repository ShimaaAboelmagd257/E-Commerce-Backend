package com.sham.e_commerce.service;

import com.sham.e_commerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class InventoryService {

    private final ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    @Transactional
    Boolean checkAndUpdateStock(Integer productId ,int quantity){
        int updated = productRepository.decreaseStockIfAvailable(productId,quantity) ;
        return updated == 1 ;
    }




}
