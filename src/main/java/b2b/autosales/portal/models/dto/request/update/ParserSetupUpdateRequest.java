package b2b.autosales.portal.models.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Parser Setup Update Request DTO")
public record ParserSetupUpdateRequest(
        @Schema(description = "Key Words", example = "[\"car\", \"auto\", \"vehicle\"]")
        List<String> keyWords,

        @Schema(description = "Filters", example = "{\"price\": \"1500\"}")
        String filters
) {}