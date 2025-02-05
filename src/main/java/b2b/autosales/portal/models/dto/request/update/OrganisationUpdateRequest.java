package b2b.autosales.portal.models.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Organisation Update Request DTO")
public record OrganisationUpdateRequest(
        @Schema(description = "Name", example = "ABC Corp Updated")
        String name,

        @Schema(description = "UNP", example = "987654321")
        String unp,

        @Schema(description = "Is Customer", example = "false")
        Boolean isCustomer
) {}