package b2b.autosales.portal.models.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Tender Update Request DTO")
public record TenderUpdateRequest(
        @Schema(description = "Source", example = "Private")
        String source,

        @Schema(description = "Title", example = "Updated Car Tender")
        String title,

        @Schema(description = "Description", example = "Updated tender for new cars")
        String description,

        @Schema(description = "Closing Date", example = "2023-10-20T12:00:00")
        LocalDateTime closingDate
) {}