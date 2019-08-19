package com.tangami.service;

import com.tangami.helper.Helper;
import com.tangami.dto.ProductListResponse;
import com.tangami.dto.ProductResponse;
import com.tangami.repository.ProductRepository;
import com.tangami.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.tangami.controller.TangamiControllerTest.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    public static final Product PRODUCT = new Product();

    public static final List<Product> REPOSITORY_PRODUCT_LIST_RESPONSE = Collections.unmodifiableList(Arrays.asList(
            PRODUCT,PRODUCT,PRODUCT));

    public static final ProductResponse PRODUCT_RESPONSE_EMPTY = new ProductResponse(null,null,null,null,null);

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Helper helper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void getAllProductsShouldRunOk() {
//before
        when(productRepository.findAll()).thenReturn(REPOSITORY_PRODUCT_LIST_RESPONSE);
        when(helper.modelResponseMapper(PRODUCT)).thenReturn(PRODUCT_RESPONSE);
//method call
        ProductListResponse listResponse = productService.getAllProducts();
//after
        assertEquals(PRODUCT_LIST_RESPONSE,listResponse);
        verify(productRepository).findAll();
    }

    @Test
    public void getSellableProductsShouldRunOk() {
//before
        when(productRepository.findProductByAmountGreaterThan(0)).thenReturn(REPOSITORY_PRODUCT_LIST_RESPONSE);
        when(helper.modelResponseMapper(PRODUCT)).thenReturn(PRODUCT_RESPONSE);
//method call
        ProductListResponse listResponse = productService.getSellableProducts();
//after
        assertEquals(PRODUCT_LIST_RESPONSE,listResponse);
        verify(productRepository).findProductByAmountGreaterThan(0);
    }

    @Test
    public void addProductProductsShouldRunOk() {
//before
        when(helper.saveModifications(PRODUCT_REQUEST)).thenReturn(PRODUCT_RESPONSE);
//method call
        ProductResponse productResponse = productService.addProduct(PRODUCT_REQUEST);
//after
        assertEquals(PRODUCT_RESPONSE,productResponse);
        verify(helper).saveModifications(PRODUCT_REQUEST);
    }

    @Test
    public void sellProductProductsShouldRunOk() {
//before
        when(helper.saveModifications(PRODUCT_REQUEST)).thenReturn(PRODUCT_RESPONSE);
//method call
        ProductResponse productResponse = productService.sellProduct(PRODUCT_REQUEST);
//after
        assertEquals(PRODUCT_RESPONSE,productResponse);
        verify(helper).saveModifications(PRODUCT_REQUEST);
    }


    @Test
    public void setProductAmountShouldRunOk() {
//before
        when(helper.saveModifications(PRODUCT_REQUEST)).thenReturn(PRODUCT_RESPONSE);
//method call
        ProductResponse productResponse = productService.setProductAmount(PRODUCT_REQUEST);
//after
        assertEquals(PRODUCT_RESPONSE,productResponse);
        verify(helper).saveModifications(PRODUCT_REQUEST);
    }
}
