package me.varnavsky.productservice.model.adidas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Embellishment {

    @JsonProperty("embellishmentOptions")
    List<EmbellishmentOptions> embellishmentOptions;

    @JsonProperty("articleType")
    String articleType;

}