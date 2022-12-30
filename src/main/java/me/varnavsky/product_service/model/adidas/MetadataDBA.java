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
public class MetadataDBA {
    List<String> assetUsage;
    String assetCategory;
    String imageStyle;
    String view;
    String usageTerms;
    String sortOrder;
    List<String> subjects;

}