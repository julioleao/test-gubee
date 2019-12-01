package com.gubee.products.services;

import com.gubee.products.document.Product;
import com.gubee.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    ProductRepository repo;

    @Override
    public Flux<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Mono<Product> findById(String id) {
        return repo.findById(id);
    }
}
