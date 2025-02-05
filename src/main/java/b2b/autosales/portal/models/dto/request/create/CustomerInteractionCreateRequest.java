package b2b.autosales.portal.models.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Customer Interaction Create Request DTO")
public record CustomerInteractionCreateRequest(
        @Schema(description = "Customer ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID customerId,

        @Schema(description = "User ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID userId,

        @Schema(description = "Interaction Type", example = "CALL")
        String interactionType,

        @Schema(description = "Interaction Date", example = "2023-10-01T12:00:00")
        LocalDateTime interactionDate,

        @Schema(description = "Notes", example = "Discussed new product")
        String notes
) {}