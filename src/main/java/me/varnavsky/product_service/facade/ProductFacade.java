package me.varnavsky.productservice.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.varnavsky.productservice.model.Product;
import me.varnavsky.productservice.model.Review;
import me.varnavsky.productservice.model.adidas.AdidasDto;
import me.varnavsky.productservice.model.review.ReviewDto;
import me.varnavsky.productservice.service.ProductService;
import me.varnavsky.productservice.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductFacade {

    private final ProductService productService;
    private final ReviewService reviewService;

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
