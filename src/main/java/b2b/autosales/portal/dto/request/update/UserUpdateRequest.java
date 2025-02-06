package b2b.autosales.portal.dto.request.update;

import b2b.autosales.portal.models.enums.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User Update Request DTO")
public record UserUpdateRequest(
        @Schema(description = "First Name", example = "John Updated")
        String firstname,

        @Schema(description = "Last Name", example = "Doe Updated")
        String lastname,

        @Schema(description = "Middle Name", example = "B.")
        String middlename,

        @Schema(description = "Email", example = "john.doe.updated@example.com")
        String email,

        @Schema(description = "Password", example = "password2")
        String password,

        @Schema(description = "Role", example = "USER")
        RoleName role
) {}