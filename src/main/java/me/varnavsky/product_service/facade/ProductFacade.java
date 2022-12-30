package me.varnavsky.product_service.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.varnavsky.product_service.model.Product;
import me.varnavsky.product_service.model.Review;
import me.varnavsky.product_service.model.adidas.AdidasDto;
import me.varnavsky.product_service.model.review.ReviewDto;
import me.varnavsky.product_service.service.ProductService;
import me.varnavsky.product_service.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductFacade {

    private final ProductService productService;
    private final ReviewService reviewService;

    /**
     * Get product info from 2 sources:
     * - Adidas public api
     * - own review service
     *
     * @param productId Product id
     * @return Composed object from both sources
     */
    public Product getProduct(String productId) {
        AdidasDto adidasDto = productService.getAdidasProduct(productId);
        ReviewDto reviewDto = reviewService.getProductReview(productId);

        return Product.builder()
                .productInfo(adidasDto)
                .review(
                        Review.builder()
                                .reviewAverageScore(reviewDto.getReviewAverageScore())
                                .reviewCount(reviewDto.getReviewCount())
                                .build()
                )
                .build();
    }
}
