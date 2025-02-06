package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Product Response DTO")
public record ProductResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "Name", example = "Car")
        String name,

        @Schema(description = "Description", example = "A new car model")
        String description,

        @Schema(description = "Price", example = "10000.0")
        Double price,

        @Schema(description = "Organisation", example = "Organisation object")
        OrganisationResponse organisation,

        @Schema(description = "Object Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID objectId
) {}