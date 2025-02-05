package b2b.autosales.portal.models.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Permission Create Request DTO")
public record PermissionCreateRequest(
        @Schema(description = "Name", example = "READ")
        String name
) {}