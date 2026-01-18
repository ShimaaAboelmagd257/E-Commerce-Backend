package com.sham.e_commerce.repository;


import com.sham.e_commerce.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<OrderEntity,Integer> {
}
