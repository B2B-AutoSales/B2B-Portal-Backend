package b2b.autosales.portal.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Cross Sale Recommendation Response DTO")
public record CrossSaleRecommendationResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Product", example = "Product object")
        ProductResponse product,

        @Schema(description = "Recommended Product", example = "Product object")
        ProductResponse recommendedProduct,

        @Schema(description = "Confidence Score", example = "0.95")
        Double confidenceScore
) {}