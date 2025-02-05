package b2b.autosales.portal.models.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product Update Request DTO")
public record ProductUpdateRequest(
        @Schema(description = "Name", example = "Car Updated")
        String name,

        @Schema(description = "Description", example = "Updated car model")
        String description,

        @Schema(description = "Price", example = "12000.0")
        Double price
) {}