package b2b.autosales.portal.dto.response;

import java.util.UUID;

import b2b.autosales.portal.models.enums.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Role Permission Response DTO")
public record RolePermissionResponse(
                @Schema(description = "Id", example = "1") UUID id,

                @Schema(description = "Role", example = "ADMIN") RoleName role,

                @Schema(description = "Permission", example = "Permission object") PermissionResponse permission) {
}