package me.varnavsky.product_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.varnavsky.product_service.exception.IntegrationException;
import me.varnavsky.product_service.model.ResponseWrapper;
import me.varnavsky.product_service.model.review.ReviewDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

  private static final String REVIEW_URI = "/review/product/{productId}";

  private final WebClient reviewWebClient;

  public ReviewDto getProductReview(String productId) {
    ResponseWrapper<ReviewDto> reviewDtoWrapper =
        reviewWebClient
            .get()
            .uri(uriBuilder -> uriBuilder.path(REVIEW_URI).build(productId))
            .retrieve()
            .onStatus(
                httpStatus -> !httpStatus.is2xxSuccessful(),
                error ->
                    Mono.error(
                        new IntegrationException(
                            "review integration exception with status: " + error.statusCode())))
            .bodyToMono(new ParameterizedTypeReference<ResponseWrapper<ReviewDto>>() {})
            .onErrorMap(
                Throwable.class,
                error -> {
                  log.error("review integration exception: {}", error.getMessage());
                  return new IntegrationException("review integration general exception");
                })
            .block();

    log.info("received product review: {}", reviewDtoWrapper);

    assert reviewDtoWrapper != null;
    return reviewDtoWrapper.getPayload();
  }
}
