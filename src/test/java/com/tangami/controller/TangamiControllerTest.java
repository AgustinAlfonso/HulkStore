package com.tangami.controller;

import com.tangami.dto.ProductListResponse;
import com.tangami.dto.ProductRequest;
import com.tangami.dto.ProductResponse;
import com.tangami.service.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TangamiControllerTest {


    public static final ProductResponse PRODUCT_RESPONSE = ProductResponse.builder()
                                                            .productName("Comic Hijitus")
                                                            .productType("Comic")
                                                            .amount(12)
                                                            .statusCod(HttpStatus.OK)
                                                            .statusDescription("Todo ha salido bien")
                                                            .build();

    public static final ProductRequest PRODUCT_REQUEST = ProductRequest.builder()
                                                        .productName("Comic Hijitus")
                                                        .productType("Comic")
                                                        .amount(12)
                                                        .build();

    public static final List<ProductResponse> PRODUCT_RESPONSE_LIST = Collections.unmodifiableList(Arrays.asList(
            PRODUCT_RESPONSE,PRODUCT_RESPONSE,PRODUCT_RESPONSE));


    public static final ProductListResponse PRODUCT_LIST_RESPONSE = ProductListResponse.builder()
                                                                    .productList(PRODUCT_RESPONSE_LIST)
                                                                    .statusCod(HttpStatus.OK)
                                                                    .statusDescription("Todo ha salido bien")
                                                                    .build();

    @Mock
    private ProductServiceImpl productService;

    @InjectMocks
    private TangamiController tangamiController;

    @Test
    public void addProductsShouldRunOk() {
//before
        when(productService.addProduct(PRODUCT_REQUEST)).thenReturn(PRODUCT_RESPONSE);
//method call
        ResponseEntity<ProductResponse> responseEntity = tangamiController.addProduct(PRODUCT_REQUEST);
        ProductResponse productResponse = responseEntity.getBody();
//after
        assertEquals(PRODUCT_RESPONSE.getProductName(),productResponse.getProductName());
        assertEquals(PRODUCT_RESPONSE.getProductType(),productResponse.getProductType());
        assertEquals(PRODUCT_RESPONSE.getAmount(),productResponse.getAmount());
        verify(productService).addProduct(PRODUCT_REQUEST);
    }

    @Test
    public void sellProductShouldRunOk() {
//before
        when(productService.sellProduct(PRODUCT_REQUEST)).thenReturn(PRODUCT_RESPONSE);
//method call
        ResponseEntity<ProductResponse> responseEntity = tangamiController.sellProduct(PRODUCT_REQUEST);
        ProductResponse productResponse = responseEntity.getBody();
//after
        assertEquals(PRODUCT_RESPONSE.getProductName(),productResponse.getProductName());
        assertEquals(PRODUCT_RESPONSE.getProductType(),productResponse.getProductType());
        assertEquals(PRODUCT_RESPONSE.getAmount(),productResponse.getAmount());
        verify(productService).sellProduct(PRODUCT_REQUEST);
    }


    @Test
    public void setProductAmountShouldRunOk() {
//before
        when(productService.setProductAmount(PRODUCT_REQUEST)).thenReturn(PRODUCT_RESPONSE);
//method call
        ResponseEntity<ProductResponse> responseEntity = tangamiController.productAmount(PRODUCT_REQUEST);
        ProductResponse productResponse = responseEntity.getBody();
//after
        assertEquals(PRODUCT_RESPONSE.getProductName(),productResponse.getProductName());
        assertEquals(PRODUCT_RESPONSE.getProductType(),productResponse.getProductType());
        assertEquals(PRODUCT_RESPONSE.getAmount(),productResponse.getAmount());
        assertEquals(PRODUCT_RESPONSE.getStatusDescription(),productResponse.getStatusDescription());
        assertEquals(PRODUCT_RESPONSE.getStatusCod(),productResponse.getStatusCod());
        verify(productService).setProductAmount(PRODUCT_REQUEST);
    }

    @Test
    public void getAllProductsShouldRunOk() {
//before
        when(productService.getAllProducts()).thenReturn(PRODUCT_LIST_RESPONSE);
//method call
        ResponseEntity<ProductListResponse> responseEntity = tangamiController.allProducts();
        ProductListResponse productResponse = responseEntity.getBody();
//after

        assertEquals(PRODUCT_LIST_RESPONSE.getProductList(),productResponse.getProductList());
        assertEquals(PRODUCT_LIST_RESPONSE.getStatusCod(),productResponse.getStatusCod());
        assertEquals(PRODUCT_LIST_RESPONSE.getStatusDescription(),productResponse.getStatusDescription());
        verify(productService).getAllProducts();
    }

    @Test
    public void getSellableProductsShouldRunOk() {
//before
        when(productService.getSellableProducts()).thenReturn(PRODUCT_LIST_RESPONSE);
//method call
        ResponseEntity<ProductListResponse> responseEntity = tangamiController.sellableProducts();
        ProductListResponse productResponse = responseEntity.getBody();
//after

        assertEquals(PRODUCT_LIST_RESPONSE.getProductList(),productResponse.getProductList());
        assertEquals(PRODUCT_LIST_RESPONSE.getStatusCod(),productResponse.getStatusCod());
        assertEquals(PRODUCT_LIST_RESPONSE.getStatusDescription(),productResponse.getStatusDescription());
        verify(productService).getSellableProducts();
    }

}
