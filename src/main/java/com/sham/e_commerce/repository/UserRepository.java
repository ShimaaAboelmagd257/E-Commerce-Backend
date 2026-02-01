package com.sham.e_commerce.repository;

import com.sham.e_commerce.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Double> {
    Optional<User> findByEmail(String email);
}
