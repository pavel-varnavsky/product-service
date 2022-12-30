package me.varnavsky.product_service.model.adidas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDescription {

    String title;
    String text;
    String subtitle;
    List<String> usps;
    WashCareInstructions washCareInstructions;
    DescriptionAssets descriptionAssets;

}