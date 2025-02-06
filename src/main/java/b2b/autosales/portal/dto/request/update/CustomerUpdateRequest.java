package b2b.autosales.portal.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Customer Update Request DTO")
public record CustomerUpdateRequest(
        @Schema(description = "Name", example = "John Doe Updated")
        String name,

        @Schema(description = "Contact Info", example = "john.doe.updated@example.com")
        String contactInfo,

        @Schema(description = "Notes", example = "Very important client")
        String notes
) {}