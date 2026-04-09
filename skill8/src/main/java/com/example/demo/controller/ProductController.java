package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;
    // 1. Category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }
    // 2. Price range
    @GetMapping("/filter")
    public List<Product> filter(
            @RequestParam double min,
            @RequestParam double max) {
        return service.getByPriceRange(min, max);
    }
    // 3. Sorted
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return service.getSortedProducts();
    }
    // 4. Expensive
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return service.getExpensiveProducts(price);
    }
}