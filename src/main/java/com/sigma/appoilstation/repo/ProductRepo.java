package com.sigma.appoilstation.repo;

import com.sigma.appoilstation.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, UUID> {

}
