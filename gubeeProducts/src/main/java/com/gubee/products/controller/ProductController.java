package com.gubee.products.controller;

import com.gubee.products.document.Product;
import com.gubee.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    //@GetMapping(value = "/products")
    public Flux<Product> getProducts(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Product> getProduct(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping(value = "/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Product>> getProductByEvents(){
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<Product> events = service.findAll();
        return Flux.zip(interval, events);
    }
}
