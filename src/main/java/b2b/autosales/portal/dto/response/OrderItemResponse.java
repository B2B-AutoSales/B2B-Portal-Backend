package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Order Item Response DTO")
public record OrderItemResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Order", example = "Order object")
        OrderResponse order,

        @Schema(description = "Product", example = "Product object")
        ProductResponse product,

        @Schema(description = "Quantity", example = "10")
        Integer quantity,

        @Schema(description = "Price", example = "100.0")
        Double price
) {}