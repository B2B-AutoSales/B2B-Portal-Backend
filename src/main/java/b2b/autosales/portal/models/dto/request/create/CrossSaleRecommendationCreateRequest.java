package b2b.autosales.portal.models.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Cross Sale Recommendation Create Request DTO")
public record CrossSaleRecommendationCreateRequest(
        @Schema(description = "Product ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID productId,

        @Schema(description = "Recommended Product ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID recommendedProductId,

        @Schema(description = "Confidence Score", example = "0.95")
        Double confidenceScore
) {}