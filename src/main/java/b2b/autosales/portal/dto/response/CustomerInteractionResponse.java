package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Customer Interaction Response DTO")
public record CustomerInteractionResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Customer", example = "Customer object")
        CustomerResponse customer,

        @Schema(description = "User", example = "User object")
        UserResponse user,

        @Schema(description = "Interaction Type", example = "CALL")
        String interactionType,

        @Schema(description = "Interaction Date", example = "2023-10-01T12:00:00")
        LocalDateTime interactionDate,

        @Schema(description = "Notes", example = "Discussed new product")
        String notes
) {}
