package com.elganiesta.springboot101.controller;

import com.elganiesta.springboot101.dao.ProductRepository;
import com.elganiesta.springboot101.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class MyRestController {
    private ProductRepository productRepository;

    public MyRestController(ProductRepository p) {
        productRepository = p;
    }

    @GetMapping(path = "/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Product p = productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/spring/products/"+p.getPhotoName()));
    }
}
