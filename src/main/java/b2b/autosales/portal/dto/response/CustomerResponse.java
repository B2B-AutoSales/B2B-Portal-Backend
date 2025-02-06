package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Customer Response DTO")
public record CustomerResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Organisation", example = "Organisation object")
        OrganisationResponse organisation,

        @Schema(description = "Name", example = "John Doe")
        String name,

        @Schema(description = "Contact Info", example = "john.doe@example.com")
        String contactInfo,

        @Schema(description = "Notes", example = "Important client")
        String notes
) {}