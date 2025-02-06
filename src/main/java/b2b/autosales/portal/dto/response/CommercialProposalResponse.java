package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Commercial Proposal Response DTO")
public record CommercialProposalResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Organisation", example = "Organisation object")
        OrganisationResponse organisation,

        @Schema(description = "User", example = "User object")
        UserResponse user,

        @Schema(description = "Tender", example = "Tender object")
        TenderResponse tender,

        @Schema(description = "Status", example = "PENDING")
        String status,

        @Schema(description = "Total Amount", example = "1000.0")
        Double totalAmount,

        @Schema(description = "Created At", example = "2023-10-01T12:00:00")
        LocalDateTime createdAt,

        @Schema(description = "Updated At", example = "2023-10-01T12:00:00")
        LocalDateTime updatedAt
) {}