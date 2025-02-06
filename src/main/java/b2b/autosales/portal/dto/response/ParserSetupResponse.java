package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.UUID;

@Schema(description = "Parser Setup Response DTO")
public record ParserSetupResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Organisation", example = "Organisation object")
        OrganisationResponse organisation,

        @Schema(description = "Key Words", example = "[\"car\", \"auto\"]")
        List<String> keyWords,

        @Schema(description = "Filters", example = "{\"price\": \"1000\"}")
        String filters
) {}