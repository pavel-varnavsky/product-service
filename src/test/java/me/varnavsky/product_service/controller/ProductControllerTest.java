package me.varnavsky.product_service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import me.varnavsky.product_service.facade.ProductFacade;
import me.varnavsky.product_service.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private ProductFacade productFacade;

  @Test
  @SneakyThrows
  void getProduct() {
    String productId = "BB5476";
    when(productFacade.getProduct(eq(productId))).thenReturn(getProductInfo());

    mockMvc
        .perform(
            get("/product/BB5476")
                .accept(MediaType.APPLICATION_JSON + ";charset=utf-8")
                .contentType(MediaType.APPLICATION_JSON + ";charset=utf-8"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON + ";charset=utf-8"))
        .andExpect(jsonPath("$.payload").exists())
        .andExpect(jsonPath("$.payload.review").exists())
        .andExpect(jsonPath("$.payload.product_info").exists())
        .andExpect(jsonPath("$.payload.product_info.id").value(productId));
  }

  private Product getProductInfo() throws JsonProcessingException {
    String p =
            """
                    {
                      "product_info": {
                        "id": "BB5476",
                        "product_type": "inline",
                        "model_number": "IAZ12",
                        "name": "Gazelle Shoes",
                        "meta_data": {
                          "canonical": "//www.adidas.co.uk/gazelle-shoes/BB5476.html",
                          "description": "Shop for Black Gazelle Shoes at adidas.co.uk! Free Shipping Options & 60 Day Returns at the official adidas online store.",
                          "keywords": "Gazelle Shoes",
                          "page_title": "adidas Gazelle Shoes - Black | adidas UK",
                          "site_name": "adidas United Kingdom"
                        },
                        "view_list": [
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/61f87dec481e4512823ea7fb0080ba1a_9366/Gazelle_Shoes_Black_BB5476_01_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Side Lateral Center View",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "1"
                            }
                          },
                          {
                            "type": "other",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/b94b0e16ce1343f8bc3ca60501799631_9366/Gazelle_Shoes_Black_BB5476_02_standard_hover.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp",
                                "plp"
                              ],
                              "asset_category": "Photography",
                              "view": "Top Portrait View",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "2"
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/8eaa5605d5294d348fd8a60501798ba0_9366/Gazelle_Shoes_Black_BB5476_03_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Bottom View",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "3"
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/de4fe345315746039934a7fb0080deaa_9366/Gazelle_Shoes_Black_BB5476_04_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Front Lateral Top View",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "4"
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4bea833201784323a15ca7fb0080eb80_9366/Gazelle_Shoes_Black_BB5476_05_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Back Lateral Top View",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "5"
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/68b2cce6c1db4120a89ea7fb0080c53d_9366/Gazelle_Shoes_Black_BB5476_06_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Side Medial Center View",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "6"
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/54c086129c774aee9c4ea6a900abd058_9366/Gazelle_Shoes_Black_BB5476_09_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Mirrored Pair View",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "7"
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/e940a084cde441a48cb1a6050179b4c0_9366/Gazelle_Shoes_Black_BB5476_41_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Detail View 1",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "8"
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2bda44fe705e4af69cf7a6050179bb6a_9366/Gazelle_Shoes_Black_BB5476_42_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Detail View 2",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "9"
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/66523e8b142f415d986da7fb008104c8_9366/Gazelle_Shoes_Black_BB5476_43_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "view": "Detail View 3",
                              "subjects": [],
                              "imageStyle": "Standard",
                              "usageTerms": "eCommerce",
                              "sortOrder": "10"
                            }
                          }
                        ],
                        "dynamic_background_assets": [
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/61f87dec481e4512823ea7fb0080ba1a_faec/Gazelle_Shoes_Black_BB5476_db01_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Side Lateral Center View",
                              "usage_terms": "eCommerce",
                              "sort_order": "1",
                              "subjects": []
                            }
                          },
                          {
                            "type": "other",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/b94b0e16ce1343f8bc3ca60501799631_faec/Gazelle_Shoes_Black_BB5476_db02_standard_hover.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp",
                                "plp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Top Portrait View",
                              "usage_terms": "eCommerce",
                              "sort_order": "2",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/8eaa5605d5294d348fd8a60501798ba0_faec/Gazelle_Shoes_Black_BB5476_db03_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Bottom View",
                              "usage_terms": "eCommerce",
                              "sort_order": "3",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/de4fe345315746039934a7fb0080deaa_faec/Gazelle_Shoes_Black_BB5476_db04_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Front Lateral Top View",
                              "usage_terms": "eCommerce",
                              "sort_order": "4",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4bea833201784323a15ca7fb0080eb80_faec/Gazelle_Shoes_Black_BB5476_db05_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Back Lateral Top View",
                              "usage_terms": "eCommerce",
                              "sort_order": "5",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/68b2cce6c1db4120a89ea7fb0080c53d_faec/Gazelle_Shoes_Black_BB5476_db06_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Side Medial Center View",
                              "usage_terms": "eCommerce",
                              "sort_order": "6",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/54c086129c774aee9c4ea6a900abd058_faec/Gazelle_Shoes_Black_BB5476_db09_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Mirrored Pair View",
                              "usage_terms": "eCommerce",
                              "sort_order": "7",
                              "subjects": []
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/e940a084cde441a48cb1a6050179b4c0_faec/Gazelle_Shoes_Black_BB5476_db41_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Detail View 1",
                              "usage_terms": "eCommerce",
                              "sort_order": "8",
                              "subjects": []
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2bda44fe705e4af69cf7a6050179bb6a_faec/Gazelle_Shoes_Black_BB5476_db42_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Detail View 2",
                              "usage_terms": "eCommerce",
                              "sort_order": "9",
                              "subjects": []
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/66523e8b142f415d986da7fb008104c8_faec/Gazelle_Shoes_Black_BB5476_db43_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Detail View 3",
                              "usage_terms": "eCommerce",
                              "sort_order": "10",
                              "subjects": []
                            }
                          }
                        ],
                        "confirmed_dynamic_background_assets": [
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/61f87dec481e4512823ea7fb0080ba1a_faec/Gazelle_Shoes_Black_BB5476_db01_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Side Lateral Center View",
                              "usage_terms": "eCommerce",
                              "sort_order": "1",
                              "subjects": []
                            }
                          },
                          {
                            "type": "other",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/b94b0e16ce1343f8bc3ca60501799631_faec/Gazelle_Shoes_Black_BB5476_db02_standard_hover.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp",
                                "plp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Top Portrait View",
                              "usage_terms": "eCommerce",
                              "sort_order": "2",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/8eaa5605d5294d348fd8a60501798ba0_faec/Gazelle_Shoes_Black_BB5476_db03_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Bottom View",
                              "usage_terms": "eCommerce",
                              "sort_order": "3",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/de4fe345315746039934a7fb0080deaa_faec/Gazelle_Shoes_Black_BB5476_db04_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Front Lateral Top View",
                              "usage_terms": "eCommerce",
                              "sort_order": "4",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4bea833201784323a15ca7fb0080eb80_faec/Gazelle_Shoes_Black_BB5476_db05_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Back Lateral Top View",
                              "usage_terms": "eCommerce",
                              "sort_order": "5",
                              "subjects": []
                            }
                          },
                          {
                            "type": "standard",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/68b2cce6c1db4120a89ea7fb0080c53d_faec/Gazelle_Shoes_Black_BB5476_db06_standard.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Side Medial Center View",
                              "usage_terms": "eCommerce",
                              "sort_order": "6",
                              "subjects": []
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/e940a084cde441a48cb1a6050179b4c0_faec/Gazelle_Shoes_Black_BB5476_db41_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Detail View 1",
                              "usage_terms": "eCommerce",
                              "sort_order": "7",
                              "subjects": []
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2bda44fe705e4af69cf7a6050179bb6a_faec/Gazelle_Shoes_Black_BB5476_db42_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Detail View 2",
                              "usage_terms": "eCommerce",
                              "sort_order": "8",
                              "subjects": []
                            }
                          },
                          {
                            "type": "detail",
                            "source": "CLOUDINARY",
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/66523e8b142f415d986da7fb008104c8_faec/Gazelle_Shoes_Black_BB5476_db43_detail.jpg",
                            "metadata": {
                              "asset_usage": [
                                "pdp"
                              ],
                              "asset_category": "Photography",
                              "image_style": "Standard",
                              "view": "Detail View 3",
                              "usage_terms": "eCommerce",
                              "sort_order": "9",
                              "subjects": []
                            }
                          }
                        ],
                        "attribute_list": {
                          "sale": false,
                          "brand": "Originals",
                          "color": "Core Black / Footwear White / Clear Granite",
                          "gender": "U",
                          "outlet": false,
                          "sport": [
                            "Lifestyle"
                          ],
                          "closure": [
                            "Laces"
                          ],
                          "surface": [
                            "Street"
                          ],
                          "category": "Shoes",
                          "size_page": "S1",
                          "productfit": [
                            "Regular"
                          ],
                          "size_fit_bar": {
                            "value": "ftw_3",
                            "markerCount": 5,
                            "selectedMarkerIndex": 2
                          },
                          "collection": [
                            "Paris",
                            "London",
                            "Vintage",
                            "Mini Me",
                            "Gifts",
                            "test_plp_1",
                            "test_plp_2",
                            "test_plp_3",
                            "test_plp_4",
                            "test_plp_5",
                            "test_plp_6",
                            "test_plp_7",
                            "test_plp_8",
                            "HOME OF CLASSICS",
                            "Retro Style",
                            "Retro Modern",
                            "BMEXPLDN",
                            "Free Personalisation",
                            "Winter",
                            "Trending",
                            "Next Day Delivery",
                            "Stocking Stuffers"
                          ],
                          "search_color": "Black",
                          "base_material": [
                            "Leather Upper",
                            "Suede Leather Upper"
                          ],
                          "technologies": [
                            "ORTHOLITE"
                          ],
                          "personalizable": true,
                          "key_category_code": "00142",
                          "mandatory_personalization": false,
                          "sustainability_ethics_compliance_ids": [
                            "Made with Recycled Content",
                            "Sustainable"
                          ],
                          "customizable": false,
                          "search_color_raw": "Black",
                          "is_orderable": true,
                          "special_launch_type": "NONE",
                          "is_flash": false,
                          "is_made_to_be_remade": false,
                          "product_sizing_category": "shoe",
                          "size_chart_id": "size-chart-size-shoes",
                          "size_chart_link": "/on/demandware.store/Sites-adidas-GB-Site/en_GB/Page-Include?cid=size-chart-size-shoes",
                          "sportSub": [
                            "Trefoil",
                            "Classics",
                            "Gazelle",
                            "Terrace"
                          ],
                          "productType": [
                            "Trainers",
                            "Other Sports Shoes",
                            "Lifestyle Trainers"
                          ],
                          "isCnCRestricted": false,
                          "isWaitingRoomProduct": false,
                          "isInPreview": false,
                          "specialLaunch": false,
                          "sizeTypes": {}
                        },
                        "breadcrumb_list": [
                          {
                            "text": "Originals",
                            "link": "/originals"
                          },
                          {
                            "text": "Shoes",
                            "link": "/originals-shoes"
                          }
                        ],
                        "callouts": {
                          "callout_top_stack": [
                            {
                              "id": "pdp-promo-nodiscount",
                              "sub_title": "This product is excluded from all promotional discounts and offers."
                            }
                          ]
                        },
                        "pricing_information": {
                          "standard_price": 80,
                          "standard_price_no_vat": 66.67,
                          "currentPrice": 80
                        },
                        "tax_class_id": "FullTax",
                        "product_description": {
                          "title": "Gazelle Shoes",
                          "text": "A low-profile classic. The Gazelle shoe started life as a football trainer and grew into an iconic streetwear staple. This pair honours the favourite version of 1991, with the same materials, colours and slightly wider proportions. A nubuck upper gives these shoes a smooth touch and soft feel.",
                          "subtitle": "The 1991 Gazelle returns in a one-to-one reissue.",
                          "usps": [
                            "Regular fit",
                            "Lace closure",
                            "Nubuck upper with synthetic leather overlays",
                            "Rubber outsole",
                            "Enjoy the comfort and performance of OrthoLite® sockliner"
                          ],
                          "wash_care_instructions": {
                            "care_instructions": []
                          },
                          "description_assets": {
                            "image_url": "https://assets.adidas.com/images/w_600,f_auto,q_auto/de4fe345315746039934a7fb0080deaa_9366/Gazelle_Shoes_Black_BB5476.jpg",
                            "video_url": null,
                            "poster_url": null
                          }
                        },
                        "product_link_list": [
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/B41645.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/340aeb9ac43847fea000a8da0182b561_9366/Gazelle_Shoes_Burgundy_B41645_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/340aeb9ac43847fea000a8da0182b561_faec/Gazelle_Shoes_Burgundy_B41645_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/340aeb9ac43847fea000a8da0182b561_faec/Gazelle_Shoes_Burgundy_B41645_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Burgundy",
                            "default_color": "Collegiate Burgundy / Cloud White / Cloud White",
                            "source": "CLOUDINARY",
                            "available_skus": 22,
                            "productId": "B41645",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/340aeb9ac43847fea000a8da0182b561_9366/Gazelle_Shoes_Burgundy_B41645_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/BB5478.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/698e41ae0196408eb16aa7fb008046ad_9366/Gazelle_Shoes_Blue_BB5478_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/698e41ae0196408eb16aa7fb008046ad_faec/Gazelle_Shoes_Blue_BB5478_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/698e41ae0196408eb16aa7fb008046ad_faec/Gazelle_Shoes_Blue_BB5478_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 80
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Blue",
                            "default_color": "Collegiate Navy / White / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 20,
                            "productId": "BB5478",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/698e41ae0196408eb16aa7fb008046ad_9366/Gazelle_Shoes_Blue_BB5478_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/BB5480.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/a847e062376346299a7ca80200807c9c_9366/Gazelle_Shoes_Grey_BB5480_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/a847e062376346299a7ca80200807c9c_faec/Gazelle_Shoes_Grey_BB5480_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/a847e062376346299a7ca80200807c9c_faec/Gazelle_Shoes_Grey_BB5480_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Grey",
                            "default_color": "Dark Grey Heather / White / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 22,
                            "productId": "BB5480",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/a847e062376346299a7ca80200807c9c_9366/Gazelle_Shoes_Grey_BB5480_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/BB5481.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/39a9b3e3ed054549a039a63c01062158_9366/Gazelle_Shoes_Blue_BB5481_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/39a9b3e3ed054549a039a63c01062158_faec/Gazelle_Shoes_Blue_BB5481_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/39a9b3e3ed054549a039a63c01062158_faec/Gazelle_Shoes_Blue_BB5481_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Blue",
                            "default_color": "Clear Sky / White / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 4,
                            "productId": "BB5481",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/39a9b3e3ed054549a039a63c01062158_9366/Gazelle_Shoes_Blue_BB5481_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/BB5486.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/417e51a1a6eb4c69b1e5a64101163a78_9366/Gazelle_Shoes_Red_BB5486_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/417e51a1a6eb4c69b1e5a64101163a78_faec/Gazelle_Shoes_Red_BB5486_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/417e51a1a6eb4c69b1e5a64101163a78_faec/Gazelle_Shoes_Red_BB5486_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 85
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Red",
                            "default_color": "Power Red / White / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 18,
                            "productId": "BB5486",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/417e51a1a6eb4c69b1e5a64101163a78_9366/Gazelle_Shoes_Red_BB5486_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/BB5487.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2a1724ae2b78414f99bdaf1d01047f7f_9366/Gazelle_Shoes_Green_BB5487_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2a1724ae2b78414f99bdaf1d01047f7f_faec/Gazelle_Shoes_Green_BB5487_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2a1724ae2b78414f99bdaf1d01047f7f_faec/Gazelle_Shoes_Green_BB5487_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 85
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Green",
                            "default_color": "Collegiate Green / Black / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 20,
                            "productId": "BB5487",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2a1724ae2b78414f99bdaf1d01047f7f_9366/Gazelle_Shoes_Green_BB5487_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/BB5498.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4c9364eb1521438a8b8ba627009a6a1f_9366/Gazelle_Shoes_White_BB5498_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4c9364eb1521438a8b8ba627009a6a1f_faec/Gazelle_Shoes_White_BB5498_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4c9364eb1521438a8b8ba627009a6a1f_faec/Gazelle_Shoes_White_BB5498_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "White",
                            "default_color": "Cloud White / Cloud White / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 22,
                            "productId": "BB5498",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4c9364eb1521438a8b8ba627009a6a1f_9366/Gazelle_Shoes_White_BB5498_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/CQ2809.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/97f86eede1374615a058a81700a27444_9366/Gazelle_Shoes_Black_CQ2809_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/97f86eede1374615a058a81700a27444_faec/Gazelle_Shoes_Black_CQ2809_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/97f86eede1374615a058a81700a27444_faec/Gazelle_Shoes_Black_CQ2809_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Black",
                            "default_color": "Core Black / Core Black / Core Black",
                            "source": "CLOUDINARY",
                            "available_skus": 20,
                            "productId": "CQ2809",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/97f86eede1374615a058a81700a27444_9366/Gazelle_Shoes_Black_CQ2809_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/FX5496.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/0afe8e7f6910414f9a65acad0116cdba_9366/Gazelle_Shoes_Purple_FX5496_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/0afe8e7f6910414f9a65acad0116cdba_faec/Gazelle_Shoes_Purple_FX5496_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/0afe8e7f6910414f9a65acad0116cdba_faec/Gazelle_Shoes_Purple_FX5496_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Purple",
                            "default_color": "Rich Purple / Cloud White / Cloud White",
                            "source": "CLOUDINARY",
                            "available_skus": 8,
                            "productId": "FX5496",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/0afe8e7f6910414f9a65acad0116cdba_9366/Gazelle_Shoes_Purple_FX5496_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GX2203.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2eb02b4211784dfab1e0ae980148d53e_9366/Gazelle_Shoes_Yellow_GX2203_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2eb02b4211784dfab1e0ae980148d53e_faec/Gazelle_Shoes_Yellow_GX2203_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2eb02b4211784dfab1e0ae980148d53e_faec/Gazelle_Shoes_Yellow_GX2203_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Yellow",
                            "default_color": "Almost Yellow / Cloud White / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 16,
                            "productId": "GX2203",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/2eb02b4211784dfab1e0ae980148d53e_9366/Gazelle_Shoes_Yellow_GX2203_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GX2206.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/7faabf426edd488f905fae9801494a32_9366/Gazelle_Shoes_Green_GX2206_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/7faabf426edd488f905fae9801494a32_faec/Gazelle_Shoes_Green_GX2206_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/7faabf426edd488f905fae9801494a32_faec/Gazelle_Shoes_Green_GX2206_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Green",
                            "default_color": "Linen Green / Cloud White / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 11,
                            "productId": "GX2206",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/7faabf426edd488f905fae9801494a32_9366/Gazelle_Shoes_Green_GX2206_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GX2207.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/83d212b8e4cf493ab6aaae99008351d6_9366/Gazelle_Shoes_Blue_GX2207_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/83d212b8e4cf493ab6aaae99008351d6_faec/Gazelle_Shoes_Blue_GX2207_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/83d212b8e4cf493ab6aaae99008351d6_faec/Gazelle_Shoes_Blue_GX2207_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Blue",
                            "default_color": "Blue / Cloud White / Gold Metallic",
                            "source": "CLOUDINARY",
                            "available_skus": 8,
                            "productId": "GX2207",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/83d212b8e4cf493ab6aaae99008351d6_9366/Gazelle_Shoes_Blue_GX2207_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GX2210.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/7ffb41cf57d542169aa4aed200dbe650_9366/Gazelle_Shoes_Black_GX2210_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/7ffb41cf57d542169aa4aed200dbe650_faec/Gazelle_Shoes_Black_GX2210_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/7ffb41cf57d542169aa4aed200dbe650_faec/Gazelle_Shoes_Black_GX2210_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Black",
                            "default_color": "Core Black / Pantone / Cloud White",
                            "source": "CLOUDINARY",
                            "available_skus": 2,
                            "productId": "GX2210",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/7ffb41cf57d542169aa4aed200dbe650_9366/Gazelle_Shoes_Black_GX2210_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GX7200.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/751e4852d64349f2a221af1700ebbb24_9366/Gazelle_Shoes_Green_GX7200_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/751e4852d64349f2a221af1700ebbb24_faec/Gazelle_Shoes_Green_GX7200_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/751e4852d64349f2a221af1700ebbb24_faec/Gazelle_Shoes_Green_GX7200_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Green",
                            "default_color": "Green / Gold Metallic / Gum",
                            "source": "CLOUDINARY",
                            "available_skus": 4,
                            "productId": "GX7200",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/751e4852d64349f2a221af1700ebbb24_9366/Gazelle_Shoes_Green_GX7200_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GX9880.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/d7f0ff786a1c451988e6aed900a5acaf_9366/Gazelle_Shoes_White_GX9880_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/d7f0ff786a1c451988e6aed900a5acaf_faec/Gazelle_Shoes_White_GX9880_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/d7f0ff786a1c451988e6aed900a5acaf_faec/Gazelle_Shoes_White_GX9880_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "White",
                            "default_color": "Cloud White / Team Power Red / Team Colleg Gold",
                            "source": "CLOUDINARY",
                            "available_skus": 8,
                            "productId": "GX9880",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/d7f0ff786a1c451988e6aed900a5acaf_9366/Gazelle_Shoes_White_GX9880_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GX9882.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4dfce8ef1f444939a791aed8012901c0_9366/Gazelle_Shoes_White_GX9882_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4dfce8ef1f444939a791aed8012901c0_faec/Gazelle_Shoes_White_GX9882_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4dfce8ef1f444939a791aed8012901c0_faec/Gazelle_Shoes_White_GX9882_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "White",
                            "default_color": "Cloud White / Team Power Red / Royal Blue",
                            "source": "CLOUDINARY",
                            "available_skus": 19,
                            "productId": "GX9882",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/4dfce8ef1f444939a791aed8012901c0_9366/Gazelle_Shoes_White_GX9882_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GY7369.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/9e5e08c3cb304fd5bdc1af1f0104f6a1_9366/Gazelle_Shoes_Blue_GY7369_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/9e5e08c3cb304fd5bdc1af1f0104f6a1_faec/Gazelle_Shoes_Blue_GY7369_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/9e5e08c3cb304fd5bdc1af1f0104f6a1_faec/Gazelle_Shoes_Blue_GY7369_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 80
                            },
                            "badge_style": "new",
                            "badge_text": "New",
                            "search_color": "Blue",
                            "default_color": "Legend Ink / Dark Blue / Gum",
                            "source": "CLOUDINARY",
                            "available_skus": 18,
                            "productId": "GY7369",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/9e5e08c3cb304fd5bdc1af1f0104f6a1_9366/Gazelle_Shoes_Blue_GY7369_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GY7370.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/b182ace2289c4680b45daef900bb6285_9366/Gazelle_Shoes_Brown_GY7370_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/b182ace2289c4680b45daef900bb6285_faec/Gazelle_Shoes_Brown_GY7370_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/b182ace2289c4680b45daef900bb6285_faec/Gazelle_Shoes_Brown_GY7370_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 80
                            },
                            "badge_style": "new",
                            "badge_text": "New",
                            "search_color": "Brown",
                            "default_color": "Bronze Strata / Pantone / Gum",
                            "source": "CLOUDINARY",
                            "available_skus": 21,
                            "productId": "GY7370",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/b182ace2289c4680b45daef900bb6285_9366/Gazelle_Shoes_Brown_GY7370_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/GY7371.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/c3c38cefc4934212bf0caf1f0105530d_9366/Gazelle_Shoes_Grey_GY7371_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/c3c38cefc4934212bf0caf1f0105530d_faec/Gazelle_Shoes_Grey_GY7371_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/c3c38cefc4934212bf0caf1f0105530d_faec/Gazelle_Shoes_Grey_GY7371_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 80
                            },
                            "badge_style": "new",
                            "badge_text": "New",
                            "search_color": "Grey",
                            "default_color": "Grey Six / Carbon / Gum",
                            "source": "CLOUDINARY",
                            "available_skus": 19,
                            "productId": "GY7371",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/c3c38cefc4934212bf0caf1f0105530d_9366/Gazelle_Shoes_Grey_GY7371_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/H06394.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/c229e5be5eda414695abae93004cf186_9366/Gazelle_Shoes_Pink_H06394_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/c229e5be5eda414695abae93004cf186_faec/Gazelle_Shoes_Pink_H06394_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/c229e5be5eda414695abae93004cf186_faec/Gazelle_Shoes_Pink_H06394_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 85
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Pink",
                            "default_color": "Super Pop / Shadow Red / White",
                            "source": "CLOUDINARY",
                            "available_skus": 16,
                            "productId": "H06394",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/c229e5be5eda414695abae93004cf186_9366/Gazelle_Shoes_Pink_H06394_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle Shoes",
                            "url": "/gazelle-shoes/H06395.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/a3dc953804b34aad87b1aead00f5a507_9366/Gazelle_Shoes_Brown_H06395_01_standard.jpg",
                            "dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/a3dc953804b34aad87b1aead00f5a507_faec/Gazelle_Shoes_Brown_H06395_db01_standard.jpg",
                            "confirmed_dynamic_background_image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/a3dc953804b34aad87b1aead00f5a507_faec/Gazelle_Shoes_Brown_H06395_db01_standard.jpg",
                            "pricing_information": {
                              "standard_price": 75
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Brown",
                            "default_color": "Mesa / Brown / White",
                            "source": "CLOUDINARY",
                            "available_skus": 10,
                            "productId": "H06395",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/a3dc953804b34aad87b1aead00f5a507_9366/Gazelle_Shoes_Brown_H06395_01_standard.jpg"
                          },
                          {
                            "type": "color-variation",
                            "name": "Gazelle",
                            "url": "/gazelle/HQ9873.html",
                            "image": "https://assets.adidas.com/images/w_600,f_auto,q_auto/18041707a56e44e7b7ceae930049afad_9366/Gazelle_Green_HQ9873_01_standard.jpg",
                            "dynamic_background_image": null,
                            "confirmed_dynamic_background_image": null,
                            "pricing_information": {
                              "standard_price": 85
                            },
                            "badge_style": null,
                            "badge_text": null,
                            "search_color": "Green",
                            "default_color": "Shadow Olive / Shadow Olive / Impact Yellow",
                            "source": "CLOUDINARY",
                            "available_skus": 11,
                            "productId": "HQ9873",
                            "altImage": "https://assets.adidas.com/images/w_600,f_auto,q_auto/18041707a56e44e7b7ceae930049afad_9366/Gazelle_Green_HQ9873_01_standard.jpg"
                          }
                        ],
                        "variation_list": [
                          {
                            "sku": "BB5476_520",
                            "size": "3"
                          },
                          {
                            "sku": "BB5476_530",
                            "size": "3.5"
                          },
                          {
                            "sku": "BB5476_540",
                            "size": "4"
                          },
                          {
                            "sku": "BB5476_550",
                            "size": "4.5"
                          },
                          {
                            "sku": "BB5476_560",
                            "size": "5"
                          },
                          {
                            "sku": "BB5476_570",
                            "size": "5.5"
                          },
                          {
                            "sku": "BB5476_580",
                            "size": "6"
                          },
                          {
                            "sku": "BB5476_590",
                            "size": "6.5"
                          },
                          {
                            "sku": "BB5476_600",
                            "size": "7"
                          },
                          {
                            "sku": "BB5476_610",
                            "size": "7.5"
                          },
                          {
                            "sku": "BB5476_620",
                            "size": "8"
                          },
                          {
                            "sku": "BB5476_630",
                            "size": "8.5"
                          },
                          {
                            "sku": "BB5476_640",
                            "size": "9"
                          },
                          {
                            "sku": "BB5476_650",
                            "size": "9.5"
                          },
                          {
                            "sku": "BB5476_660",
                            "size": "10"
                          },
                          {
                            "sku": "BB5476_670",
                            "size": "10.5"
                          },
                          {
                            "sku": "BB5476_680",
                            "size": "11"
                          },
                          {
                            "sku": "BB5476_690",
                            "size": "11.5"
                          },
                          {
                            "sku": "BB5476_700",
                            "size": "12"
                          },
                          {
                            "sku": "BB5476_710",
                            "size": "12.5"
                          },
                          {
                            "sku": "BB5476_720",
                            "size": "13"
                          },
                          {
                            "sku": "BB5476_730",
                            "size": "13.5"
                          }
                        ],
                        "embellishment": {
                          "embellishmentOptions": [
                            {
                              "position": "leftShoe",
                              "fields": [
                                {
                                  "type": "text",
                                  "key": "leftShoeText",
                                  "validation": "^[#@?&%$0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜ ]*$",
                                  "maxLength": 11,
                                  "minLength": 0,
                                  "textColor": "adidas - 401 White",
                                  "usesStock": false,
                                  "stockCollection": null
                                }
                              ],
                              "positionPrice": 7.5,
                              "allowChooseOwnText": true
                            },
                            {
                              "position": "rightShoe",
                              "fields": [
                                {
                                  "type": "text",
                                  "key": "rightShoeText",
                                  "validation": "^[#@?&%$0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜ ]*$",
                                  "maxLength": 11,
                                  "minLength": 0,
                                  "textColor": "adidas - 401 White",
                                  "usesStock": false,
                                  "stockCollection": null
                                }
                              ],
                              "positionPrice": 7.5,
                              "allowChooseOwnText": true
                            }
                          ],
                          "articleType": "footwear"
                        },
                        "recommendationsEnabled": true
                      },
                      "review": {
                        "review_average_score": 3.125,
                        "review_count": 8
                      }
                    }
                    """;

    return objectMapper().readValue(p, Product.class);
  }

  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    return objectMapper;
  }

}
