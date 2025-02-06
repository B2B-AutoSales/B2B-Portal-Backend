package b2b.autosales.portal.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Order Update Request DTO")
public record OrderUpdateRequest(
        @Schema(description = "Status", example = "COMPLETED")
        String status,

        @Schema(description = "Total Amount", example = "1200.0")
        Double totalAmount
) {}