package b2b.autosales.portal.dto.request.create;

import b2b.autosales.portal.models.enums.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Role Permission Create Request DTO")
public record RolePermissionCreateRequest(
        @Schema(description = "Role", example = "ADMIN")
        RoleName role,

        @Schema(description = "Permission ID", example = "1")
        Long permissionId
) {}