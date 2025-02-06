package b2b.autosales.portal.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Commercial Proposal Create Request DTO")
public record CommercialProposalCreateRequest(
        @Schema(description = "Organisation ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID organisationId,

        @Schema(description = "User ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID userId,

        @Schema(description = "Tender ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID tenderId,

        @Schema(description = "Status", example = "PENDING")
        String status,

        @Schema(description = "Total Amount", example = "1000.0")
        Double totalAmount
) {}