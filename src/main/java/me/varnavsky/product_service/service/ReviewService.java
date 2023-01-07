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
import reactor.util.retry.Retry;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

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
            //                .headers(header -> header.setBearerAuth("SOME_TOKEN"))
            .retrieve()
            .onStatus(
                httpStatus -> !httpStatus.is2xxSuccessful(),
                error -> Mono.error(new IntegrationException("review integration exception")))
            .bodyToMono(new ParameterizedTypeReference<ResponseWrapper<ReviewDto>>() {})
            .retryWhen(Retry.fixedDelay(2, Duration.of(5, ChronoUnit.SECONDS)))
            .onErrorResume(
                Throwable.class,
                ex -> {
                  log.error("review throwable => {}", ex.toString());
                  throw new IntegrationException("review integration exception");
                })
            .block();

    log.info("received product review: {}", reviewDtoWrapper);

    if (Optional.ofNullable(reviewDtoWrapper)
            .orElseThrow(() -> new IntegrationException("review integration received empty result"))
            .getPayload()
        == null) {
      return new ReviewDto();
    }

    return reviewDtoWrapper.getPayload();
  }
}
