package com.sigma.appoilstation.controller;

import com.sigma.appoilstation.entity.Product;
import com.sigma.appoilstation.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepo repo;

    @GetMapping
    List<Product> getAll(){
        return repo.findAll(Sort.by("timestamp").descending());
    }

    @PostMapping
    String post(@RequestBody String name){
        Product product = new Product();
        product.setName(name);
        repo.save(product);
        return "saved";
    }

    @PutMapping("/{id}")
    String put(@PathVariable("id") final UUID id, @RequestBody String name){
        Optional<Product> byId = repo.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            product.setName(name);
            repo.save(product);
            return "saved";
        }
        return "noturi id";
    }
}
