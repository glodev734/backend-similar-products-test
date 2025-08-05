package com.example.similar_products.service;

import com.example.similar_products.client.ExternalProductClient;
import com.example.similar_products.domain.SimilarItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SimilarProductServiceImpl implements ProductService {

    private final ExternalProductClient client;

    public SimilarProductServiceImpl(ExternalProductClient client) {
        this.client = client;
    }

    @Override
    public List<SimilarItemDTO> findSimilarItems(String productId) {
        return client.getSimilarProductIds(productId).stream()
                .map(id -> {
                    try {
                        return client.getProductDetail(id);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
