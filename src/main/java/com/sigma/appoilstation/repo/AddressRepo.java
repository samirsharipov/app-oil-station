package com.sigma.appoilstation.repo;

import com.sigma.appoilstation.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Integer> {
    List<Address> findAllByActiveTrue();
}
