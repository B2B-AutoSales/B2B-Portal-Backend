package b2b.autosales.portal.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Customer Interaction Update Request DTO")
public record CustomerInteractionUpdateRequest(
        @Schema(description = "Interaction Type", example = "EMAIL")
        String interactionType,

        @Schema(description = "Interaction Date", example = "2023-10-02T12:00:00")
        LocalDateTime interactionDate,

        @Schema(description = "Notes", example = "Follow-up email sent")
        String notes
) {}