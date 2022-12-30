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
public
class SizeFitBar {

    String value;

    @JsonProperty("markerCount")
    int markerCount;

    @JsonProperty("selectedMarkerIndex")
    int selectedMarkerIndex;

}