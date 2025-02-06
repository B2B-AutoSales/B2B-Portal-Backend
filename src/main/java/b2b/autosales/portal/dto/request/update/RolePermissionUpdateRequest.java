package b2b.autosales.portal.dto.request.update;

import b2b.autosales.portal.models.enums.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Role Permission Update Request DTO")
public record RolePermissionUpdateRequest(
        @Schema(description = "Role", example = "USER")
        RoleName role,

        @Schema(description = "Permission ID", example = "2")
        Long permissionId
) {}