package com.example.similar_products.service;

import com.example.similar_products.client.ExternalProductClient;
import com.example.similar_products.domain.SimilarItemDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ExternalProductClient client;

    @InjectMocks
    SimilarProductServiceImpl service;

    @Test
    void returnsFilledDtoList_whenApisSucceed() {
        when(client.getSimilarProductIds("1")).thenReturn(List.of("2", "3"));

        SimilarItemDTO dto2 = new SimilarItemDTO();
        dto2.setId("2");
        SimilarItemDTO dto3 = new SimilarItemDTO();
        dto3.setId("3");

        when(client.getProductDetail("2")).thenReturn(dto2);
        when(client.getProductDetail("3")).thenReturn(dto3);

        List<SimilarItemDTO> result = service.findSimilarItems("1");

        assertThat(result)
                .extracting(SimilarItemDTO::getId)
                .containsExactly("2", "3");
    }
}
