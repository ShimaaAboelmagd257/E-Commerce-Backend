package com.sham.e_commerce.repository;

import com.sham.e_commerce.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

    @Modifying
    @Query("""
        UPDATE ProductEntity p
        SET p.stock_quantity = p.stock_quantity - :quantity
        WHERE p.id = :productId
          AND p.stock_quantity >= :quantity
    """)
    int decreaseStockIfAvailable(
            @Param("productId") Integer productId,
            @Param("quantity") int quantity
    );



}
