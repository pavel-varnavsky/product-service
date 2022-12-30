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
public class Callouts {

    List<CalloutTopStack> calloutTopStack;
}