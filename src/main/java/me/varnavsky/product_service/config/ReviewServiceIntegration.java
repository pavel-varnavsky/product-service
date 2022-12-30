package me.varnavsky.product_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "integration.review-service")
@Data
public class ReviewServiceIntegration {

  private String url;
  private String login;
  private String password;
}
