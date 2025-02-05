package b2b.autosales.portal.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Tender Response DTO")
public record TenderResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Source", example = "Government")
        String source,

        @Schema(description = "Title", example = "New Car Tender")
        String title,

        @Schema(description = "Description", example = "Tender for new cars")
        String description,

        @Schema(description = "Published Date", example = "2023-10-01T12:00:00")
        LocalDateTime publishedDate,

        @Schema(description = "Closing Date", example = "2023-10-15T12:00:00")
        LocalDateTime closingDate,

        @Schema(description = "Organisation", example = "Organisation object")
        OrganisationResponse organisation,

        @Schema(description = "Created At", example = "2023-10-01T12:00:00")
        LocalDateTime createdAt,

        @Schema(description = "Updated At", example = "2023-10-01T12:00:00")
        LocalDateTime updatedAt
) {}