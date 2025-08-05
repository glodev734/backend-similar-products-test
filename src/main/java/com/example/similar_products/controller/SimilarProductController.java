package com.example.similar_products.controller;

import com.example.similar_products.domain.SimilarItemDTO;
import com.example.similar_products.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/product")
public class SimilarProductController {

    private final ProductService service;

    public SimilarProductController(ProductService service) {
        this.service = service;
    }
    @Operation(summary = "Retrieve a list of items similar to the given item ID")
    @GetMapping("/{id}/similar")
    public ResponseEntity<List<SimilarItemDTO>> getSimilarProducts(@PathVariable String id) {
        List<SimilarItemDTO> similarProducts = service.findSimilarItems(id);
        return ResponseEntity.ok(similarProducts);
    }
}
