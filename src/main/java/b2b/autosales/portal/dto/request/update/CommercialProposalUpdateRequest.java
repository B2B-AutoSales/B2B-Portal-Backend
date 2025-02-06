package b2b.autosales.portal.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Commercial Proposal Update Request DTO")
public record CommercialProposalUpdateRequest(
        @Schema(description = "Status", example = "APPROVED")
        String status,

        @Schema(description = "Total Amount", example = "1200.0")
        Double totalAmount
) {}