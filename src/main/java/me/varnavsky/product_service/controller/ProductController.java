package me.varnavsky.product_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.varnavsky.product_service.facade.ProductFacade;
import me.varnavsky.product_service.model.Product;
import me.varnavsky.product_service.model.ResponseWrapper;
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

  /**
   * Get product info from 2 sources:
   * - Adidas public API
   * - own review service
   *
   * @param productId Product id
   * @return Composed object from both sources
   */
  @GetMapping("/{productId}")
  public ResponseWrapper<Product> getProduct(@PathVariable String productId) {
    return ResponseWrapper.of(productFacade.getProduct(productId));
  }
}
