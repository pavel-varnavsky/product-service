package me.varnavsky.productservice.model.adidas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductLinkList {

    String type;

    @JsonProperty("productId")
    String productId;
    String name;
    String url;
    String image;

    @JsonProperty("altImage")
    String altImage;
    String dynamicBackgroundImage;
    String confirmedDynamicBackgroundImage;
    PricingInformationPLL pricingInformation;
    String badgeStyle;
    String badgeText;
    String searchColor;
    String defaultColor;
    String source;
    int availableSkus;


}