package me.varnavsky.productservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.varnavsky.productservice.facade.ProductFacade;
import me.varnavsky.productservice.model.Product;
import me.varnavsky.productservice.model.ResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(value = "/product", produces = APPLICATION_JSON_VALUE + ";charset=utf-8")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

  private final ProductFacade productFacade;

  @GetMapping("/{productId}")
  public ResponseWrapper<Product> getProduct(@PathVariable String productId) {
    return ResponseWrapper.of(productFacade.getProduct(productId));
  }
}
