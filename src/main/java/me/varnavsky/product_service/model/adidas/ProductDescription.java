package me.varnavsky.productservice.model.adidas;

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