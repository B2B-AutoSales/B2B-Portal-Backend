package b2b.autosales.portal.models.dto.request.update;

import b2b.autosales.portal.models.enums.RegistrationStatusName;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Registration Request Update Request DTO")
public record RegistrationRequestUpdateRequest(
        @Schema(description = "Status", example = "APPROVED")
        RegistrationStatusName status
) {}