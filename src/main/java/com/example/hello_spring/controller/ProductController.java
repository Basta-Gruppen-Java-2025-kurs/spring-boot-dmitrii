package com.example.hello_spring.controller;

import com.example.hello_spring.model.Product;
import com.example.hello_spring.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        return service
                .getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(418)
                        .build());
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestParam String name, @RequestParam double price) {
        Product p = new Product(-1, name, price);
        p = service.addProduct(p);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean removed = service.delete(id);
        return (removed ? ResponseEntity.noContent() : ResponseEntity.notFound()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestParam String name, @RequestParam
    double price) {
        Product p = service.updateProduct(id, new Product(-1, name, price));
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
}
