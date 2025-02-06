package b2b.autosales.portal.dto.request.create;

import b2b.autosales.portal.models.enums.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "User Create Request DTO")
public record UserCreateRequest(
        @Schema(description = "First Name", example = "John")
        String firstname,

        @Schema(description = "Last Name", example = "Doe")
        String lastname,

        @Schema(description = "Middle Name", example = "A.")
        String middlename,

        @Schema(description = "Email", example = "john.doe@example.com")
        String email,

        @Schema(description = "Password", example = "password1")
        String password,

        @Schema(description = "Organisation ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID organisationId,

        @Schema(description = "Role", example = "ADMIN")
        RoleName role
) {}
