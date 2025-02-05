package b2b.autosales.portal.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Order Response DTO")
public record OrderResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Organisation", example = "Organisation object")
        OrganisationResponse organisation,

        @Schema(description = "User", example = "User object")
        UserResponse user,

        @Schema(description = "Status", example = "PROCESSING")
        String status,

        @Schema(description = "Total Amount", example = "1000.0")
        Double totalAmount,

        @Schema(description = "Created At", example = "2023-10-01T12:00:00")
        LocalDateTime createdAt,

        @Schema(description = "Updated At", example = "2023-10-01T12:00:00")
        LocalDateTime updatedAt
) {}