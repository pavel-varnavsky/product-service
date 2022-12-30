package me.varnavsky.product_service.config.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.varnavsky.product_service.config.AdidasServiceIntegration;
import me.varnavsky.product_service.config.ReviewServiceIntegration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.*;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

  private final AdidasServiceIntegration adidasServiceIntegration;
  private final ReviewServiceIntegration reviewServiceIntegration;

  private final ObjectMapper objectMapper;

  /**
   * Creates ExchangeStrategies bean to use for convert Json to POJO and vice versa.
   *
   * @return ExchangeStrategies object
   */
  @Bean
  public ExchangeStrategies exchangeStrategies() {
    return ExchangeStrategies.builder()
        .codecs(
            configurer ->
                configurer
                    .defaultCodecs()
                    .jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper)))
        .build();
  }

  /**
   * Creates WebClient bean to interact with Adidas API.
   *
   * @param exchangeStrategies Exchange strategy between Json and POJO
   * @return WebClient object
   */
  @Bean
  public WebClient adidasWebClient(ExchangeStrategies exchangeStrategies) {
    return WebClient.builder()
        .baseUrl(adidasServiceIntegration.getUrl())
        .exchangeStrategies(exchangeStrategies)
        .build();
  }

  /**
   * Creates WebClient bean to interact with review-service.
   * Uses basic authentication for simple security. Better approach is JWT token.
   *
   * @param exchangeStrategies Exchange strategy between Json and POJO
   * @return WebClient object
   */
  @Bean
  public WebClient reviewWebClient(ExchangeStrategies exchangeStrategies) {
    return WebClient.builder()
        .baseUrl(reviewServiceIntegration.getUrl())
        .filter(
            basicAuthentication(
                reviewServiceIntegration.getLogin(), reviewServiceIntegration.getPassword()))
        .exchangeStrategies(exchangeStrategies)
        .build();
  }
}
