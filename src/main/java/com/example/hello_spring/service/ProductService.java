package com.example.hello_spring.service;

import com.example.hello_spring.model.Product;
import com.example.hello_spring.model.dto.ProductRequestDTO;
import com.example.hello_spring.model.dto.ProductResponseDTO;
import com.example.hello_spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return  repository.findAll();
    }

    public Optional<Product> getById(int id) {
        return repository.findById(id);
    }

    public List<Product> searchByName(String name) {
        return repository.findByName(name);
    }

    public ProductResponseDTO addProduct(ProductRequestDTO p) {
        return toResponseDTO(repository.save(toEntity(p)));
    }

    public boolean delete(int id) {
        return repository.deleteById(id);
    }

    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productDTO) {
        Optional<Product> existing = repository.findById(id);
        if(existing.isPresent()) {
            Product p = existing.get();
            p.setName(productDTO.getName());
            p.setPrice(productDTO.getPrice());
            return toResponseDTO(p);
        }
        return null;
    }

    public void addInternalRating(int id, String internalRating) {
        Optional<Product> existing = repository.findById(id);
        existing.ifPresent(product -> product.setInternalRating(internalRating));
    }

    public Product patchProduct(int id, Product product) {
        Optional<Product> existing = repository.findById(id);
        if(existing.isPresent()) {
            Product p = existing.get();
            if (product.getName() != null) {
                p.setName(product.getName());
            }
            if (product.getPrice() != 0.0) {
                p.setPrice(product.getPrice());
            }
            return p;
        }
        return null;
    }

    private ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(product.getId(), product.getName(), product.getPrice());
    }

    private Product toEntity(ProductRequestDTO requestDTO) {
        Product product = new Product();
        if (!requestDTO.getName().isBlank()) {
            product.setName(requestDTO.getName());
        }
        if (requestDTO.getPrice() != 0) {
            product.setPrice(requestDTO.getPrice());
        }
        if (!requestDTO.getInternalRating().isBlank()) {
            product.setInternalRating(requestDTO.getInternalRating());
        }
        return product;
    }
}
