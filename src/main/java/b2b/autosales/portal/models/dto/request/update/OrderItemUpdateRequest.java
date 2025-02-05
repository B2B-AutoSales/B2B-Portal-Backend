package b2b.autosales.portal.models.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Order Item Update Request DTO")
public record OrderItemUpdateRequest(
        @Schema(description = "Quantity", example = "15")
        Integer quantity,

        @Schema(description = "Price", example = "150.0")
        Double price
) {}