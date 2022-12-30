package me.varnavsky.product_service.model.adidas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fields {

  String type;
  String key;

  @JsonProperty("maxLength")
  BigDecimal maxLength;

  @JsonProperty("minLength")
  BigDecimal minLength;

  String validation;

  @JsonProperty("textColor")
  String textColor;

  @JsonProperty("usesStock")
  Boolean usesStock;

  @JsonProperty("stockCollection")
  String stockCollection;
}
