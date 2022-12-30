package me.varnavsky.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.varnavsky.product_service.model.adidas.AdidasDto;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    AdidasDto productInfo;
    Review review;
}
