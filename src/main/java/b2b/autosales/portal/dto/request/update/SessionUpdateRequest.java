package b2b.autosales.portal.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Session Update Request DTO")
public record SessionUpdateRequest(
        @Schema(description = "Is Blocked", example = "true")
        Boolean isBlocked
) {}