package b2b.autosales.portal.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Order Item Create Request DTO")
public record OrderItemCreateRequest(
        @Schema(description = "Order ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID orderId,

        @Schema(description = "Product ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID productId,

        @Schema(description = "Quantity", example = "10")
        Integer quantity,

        @Schema(description = "Price", example = "100.0")
        Double price
) {}