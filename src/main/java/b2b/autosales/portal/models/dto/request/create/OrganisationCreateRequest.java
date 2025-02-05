package b2b.autosales.portal.models.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Organisation Create Request DTO")
public record OrganisationCreateRequest(
        @Schema(description = "Name", example = "ABC Corp")
        String name,

        @Schema(description = "UNP", example = "123456789")
        String unp,

        @Schema(description = "Is Customer", example = "true")
        Boolean isCustomer
) {}
