package me.varnavsky.product_service.model.adidas;

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
public class AttributeList {

    Boolean sale;
    String brand;
    String color;
    String gender;
    Boolean outlet;
    List<String> sport;
    List<String> closure;
    List<String> surface;
    String category;
    String sizePage;

    @JsonProperty("sportSub")
    List<String> sportSub;
    List<String> productfit;
    SizeFitBar sizeFitBar;
    List<String> collection;
    String searchColor;
    List<String> baseMaterial;

    @JsonProperty("productType")
    List<String> productType;
    List<String> technologies;
    Boolean personalizable;

    @JsonProperty("isCnCRestricted")
    Boolean isCnCRestricted;
    String keyCategoryCode;
    Boolean mandatoryPersonalization;
    List<String> sustainabilityEthicsComplianceIds;
    Boolean customizable;
    String searchColorRaw;
    Boolean isOrderable;

    @JsonProperty("isWaitingRoomProduct")
    Boolean isWaitingRoomProduct;

    @JsonProperty("isInPreview")
    Boolean isInPreview;

    @JsonProperty("specialLaunch")
    Boolean specialLaunch;

    String specialLaunchType;

    @JsonProperty("sizeTypes")
    Object sizeTypes;
    Boolean isFlash;
    Boolean isMadeToBeRemade;
    String productSizingCategory;
    String sizeChartId;
    String sizeChartLink;

}