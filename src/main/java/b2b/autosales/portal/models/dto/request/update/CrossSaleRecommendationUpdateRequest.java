package b2b.autosales.portal.models.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Cross Sale Recommendation Update Request DTO")
public record CrossSaleRecommendationUpdateRequest(
        @Schema(description = "Confidence Score", example = "0.98")
        Double confidenceScore
) {}