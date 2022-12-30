package me.varnavsky.product_service.model.adidas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdidasDto {

    String id;
    String productType;
    String modelNumber;
    String name;
    MetadataMain metaData;
    List<ViewList> viewList;
    List<DynamicBackgroundAssets> dynamicBackgroundAssets;
    List<ConfirmedDynamicBackgroundAssets> confirmedDynamicBackgroundAssets;
    AttributeList attributeList;
    List<BreadcrumbList> breadcrumbList;
    Callouts callouts;
    PricingInformation pricingInformation;
    String taxClassId;
    ProductDescription productDescription;

    @JsonProperty("recommendationsEnabled")
    Boolean recommendationsEnabled;
    List<ProductLinkList> productLinkList;
    List<VariationList> variationList;
    Embellishment embellishment;

}