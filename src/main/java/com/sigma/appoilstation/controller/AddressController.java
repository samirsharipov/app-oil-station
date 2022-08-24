package com.sigma.appoilstation.controller;

import com.sigma.appoilstation.entity.Address;
import com.sigma.appoilstation.payload.AddressDto;
import com.sigma.appoilstation.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressRepo addressRepo;

    @GetMapping
    public List<Address> findAll() {
        return addressRepo.findAllByActiveTrue();
    }

    @PostMapping
    public Address create(@RequestBody AddressDto dto){
        Address address = new Address();
        address.setAddressName(dto.getAddressName());
        address.setActive(dto.isActive());
        return addressRepo.save(address);
    }
}
