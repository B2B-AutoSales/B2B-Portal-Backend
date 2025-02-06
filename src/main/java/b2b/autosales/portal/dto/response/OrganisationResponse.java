package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Organisation Response DTO")
public record OrganisationResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Name", example = "ABC Corp")
        String name,

        @Schema(description = "UNP", example = "123456789")
        String unp,

        @Schema(description = "Is Customer", example = "true")
        Boolean isCustomer
) {}