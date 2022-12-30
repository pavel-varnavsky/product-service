package me.varnavsky.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.varnavsky.productservice.model.adidas.AdidasDto;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    AdidasDto productInfo;
    Review review;
}
