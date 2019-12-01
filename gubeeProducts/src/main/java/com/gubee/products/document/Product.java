package com.gubee.products.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String productName;
    private String description;
    private List<String> targetMarket;
    private List<String> stack;

    public Product(String id, String productName, String description, List<String> targetMarket, List<String> stack) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.targetMarket = targetMarket;
        this.stack = stack;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTargetMarket() {
        return targetMarket;
    }

    public void setTargetMarket(List<String> targetMarket) {
        this.targetMarket = targetMarket;
    }

    public List<String>getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }
}
