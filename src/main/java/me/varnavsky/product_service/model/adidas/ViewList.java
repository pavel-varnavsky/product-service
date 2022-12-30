package me.varnavsky.product_service.model.adidas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ViewList {

    String type;
    String source;
    String imageUrl;
    MetadataViewList metadata;

}