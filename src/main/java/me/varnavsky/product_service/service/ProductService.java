package me.varnavsky.product_service.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.varnavsky.product_service.exception.IntegrationException;
import me.varnavsky.product_service.model.adidas.AdidasDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private static final String PRODUCT_URI = "/products/{productId}";

  private final WebClient adidasWebClient;

  /**
   * Get product info from Adidas public API
   *
   * @param productId Product id
   * @return Adidas DTO
   */
  @SneakyThrows
  public AdidasDto getAdidasProduct(String productId) {
    AdidasDto adidasDto =
        adidasWebClient
            .get()
            .uri(uriBuilder -> uriBuilder.path(PRODUCT_URI).build(productId))
            .retrieve()
            .onStatus(
                httpStatus -> !httpStatus.is2xxSuccessful(),
                error ->
                    Mono.error(
                        new IntegrationException(
                            "adidas integration exception with incorrect status")))
            .bodyToMono(AdidasDto.class)
            .retryWhen(Retry.fixedDelay(2, Duration.of(5, ChronoUnit.SECONDS)))
            .onErrorContinue(
                (throwable, o) -> {
                  log.info("adidas throwable => {}", throwable.toString());
                  throw new IntegrationException("adidas integration exception");
                })
            .block();

    log.info("received adidas product: {}", adidasDto);

    if (adidasDto == null) {
      throw new IntegrationException("adidas integration received empty result");
    }

    return adidasDto;
  }
}
