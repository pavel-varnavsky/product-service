package me.varnavsky.productservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "integration.adidas-service")
@Data
public class AdidasServiceIntegration {
  private String url;
}
