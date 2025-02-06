package b2b.autosales.portal.dto.response;

import b2b.autosales.portal.models.enums.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Schema(description = "User Response DTO")
public record UserResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

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

        @Schema(description = "Organisation", example = "Organisation object")
        OrganisationResponse organisation,

        @Schema(description = "Created At", example = "2023-10-01")
        LocalDate createdAt,

        @Schema(description = "Updated At", example = "2023-10-01")
        LocalDate updatedAt,

        @Schema(description = "Deleted At", example = "2023-10-01")
        LocalDate deletedAt,

        @Schema(description = "Is Blocked", example = "false")
        Boolean isBlocked,

        @Schema(description = "Role", example = "ADMIN")
        RoleName role,

        @Schema(description = "Registration Request", example = "Registration Request object")
        RegistrationRequestResponse registrationRequest,

        @Schema(description = "Sessions", example = "List of Session objects")
        List<SessionResponse> sessions
) {}