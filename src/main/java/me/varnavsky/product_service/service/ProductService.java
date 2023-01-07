package me.varnavsky.product_service.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.varnavsky.product_service.exception.IntegrationException;
import me.varnavsky.product_service.model.ErrorDto;
import me.varnavsky.product_service.model.adidas.AdidasDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
                httpStatus -> httpStatus.equals(HttpStatus.NOT_FOUND),
                error ->
                    error
                        .bodyToMono(ErrorDto.class)
                        .flatMap(
                            body -> {
                              log.error("{} : {}", productId, body.getMessage());
                              return Mono.error(
                                  new IntegrationException(productId + " : " + body.getMessage()));
                            }))
            .onStatus(
                httpStatus -> !httpStatus.is2xxSuccessful(),
                error -> {
                  log.error("adidas integration error: {}", error);
                  return Mono.error(new IntegrationException("adidas integration exception"));
                })
            .bodyToMono(AdidasDto.class)
            .onErrorMap(
                Throwable.class,
                error -> {
                  log.error("adidas integration exception: {}", error.getMessage());
                  return new IntegrationException("adidas integration general exception");
                })
            .block();

    log.info("received adidas product: {}", adidasDto);

    return adidasDto;
  }
}
