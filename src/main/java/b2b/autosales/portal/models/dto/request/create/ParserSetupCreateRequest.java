package b2b.autosales.portal.models.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.UUID;

@Schema(description = "Parser Setup Create Request DTO")
public record ParserSetupCreateRequest(
        @Schema(description = "Organisation ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID organisationId,

        @Schema(description = "Key Words", example = "[\"car\", \"auto\"]")
        List<String> keyWords,

        @Schema(description = "Filters", example = "{\"price\": \"1000\"}")
        String filters
) {}