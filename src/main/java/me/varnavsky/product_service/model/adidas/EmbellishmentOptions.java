package me.varnavsky.productservice.model.adidas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmbellishmentOptions {

    String position;

    @JsonProperty("positionPrice")
    BigDecimal positionPrice;

    @JsonProperty("allowChooseOwnText")
    Boolean allowChooseOwnText;
    List<Fields> fields;

}