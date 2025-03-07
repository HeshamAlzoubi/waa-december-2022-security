package edu.miu.lab5.controller;


import edu.miu.lab5.entity.Product;
import edu.miu.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void save(@RequestBody Product p) {
        productService.save(p);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable long id) {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long productId, @RequestBody Product product) {
        productService.save(productId,product);
    }

}
