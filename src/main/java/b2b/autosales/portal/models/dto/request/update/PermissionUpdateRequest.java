package b2b.autosales.portal.models.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Permission Update Request DTO")
public record PermissionUpdateRequest(
        @Schema(description = "Name", example = "WRITE")
        String name
) {}