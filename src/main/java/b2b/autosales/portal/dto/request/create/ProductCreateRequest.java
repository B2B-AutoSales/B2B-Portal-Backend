package b2b.autosales.portal.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Product Create Request DTO")
public record ProductCreateRequest(
        @Schema(description = "Name", example = "Car")
        String name,

        @Schema(description = "Description", example = "A new car model")
        String description,

        @Schema(description = "Price", example = "10000.0")
        Double price,

        @Schema(description = "Organisation ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID organisationId,

        @Schema(description = "Object ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID objectId
) {}