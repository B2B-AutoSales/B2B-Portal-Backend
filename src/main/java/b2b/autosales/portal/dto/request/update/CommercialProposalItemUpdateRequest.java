package b2b.autosales.portal.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Commercial Proposal Item Update Request DTO")
public record CommercialProposalItemUpdateRequest(
        @Schema(description = "Quantity", example = "15")
        Integer quantity,

        @Schema(description = "Price", example = "150.0")
        Double price
) {}