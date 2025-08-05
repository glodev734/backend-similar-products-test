package com.example.similar_products.service;

import com.example.similar_products.domain.SimilarItemDTO;
import java.util.List;

public interface ProductService {
    List<SimilarItemDTO> findSimilarItems(String productId);
}
