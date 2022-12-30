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
public class MetadataViewList {
    List<String> assetUsage;
    String assetCategory;

    @JsonProperty("imageStyle")
    String imageStyle;

    String view;

    @JsonProperty("usageTerms")
    String usageTerms;

    @JsonProperty("sortOrder")
    String sortOrder;
    List<String> subjects;

}