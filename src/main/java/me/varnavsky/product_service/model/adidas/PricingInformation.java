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
public class PricingInformation {

    @JsonProperty("currentPrice")
    BigDecimal currentPrice;
    BigDecimal standardPrice;
    BigDecimal standardPriceNoVat;

}