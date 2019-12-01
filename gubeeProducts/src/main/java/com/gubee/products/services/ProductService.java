package com.gubee.products.services;

import com.gubee.products.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> findAll();
    Mono<Product> findById(String id);

}
