package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.CrossSaleRecommendationCreateRequest;
import b2b.autosales.portal.dto.request.update.CrossSaleRecommendationUpdateRequest;
import b2b.autosales.portal.dto.response.CrossSaleRecommendationResponse;
import b2b.autosales.portal.service.CrossSaleRecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cross-sale-recommendations")
@Tag(name = "Cross Sale Recommendation Management", description = "APIs for managing cross-sale recommendations")
public class CrossSaleRecommendationController {

    private final CrossSaleRecommendationService crossSaleRecommendationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new cross-sale recommendation", description = "Creates a new cross-sale recommendation with the provided details")
    @ApiResponse(responseCode = "201", description = "Cross-sale recommendation created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public CrossSaleRecommendationResponse createCrossSaleRecommendation(
            @RequestBody @Valid CrossSaleRecommendationCreateRequest createRequest) {
        return crossSaleRecommendationService.createCrossSaleRecommendation(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a cross-sale recommendation", description = "Updates an existing cross-sale recommendation with the provided details")
    @ApiResponse(responseCode = "200", description = "Cross-sale recommendation updated successfully")
    @ApiResponse(responseCode = "404", description = "Cross-sale recommendation not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public CrossSaleRecommendationResponse updateCrossSaleRecommendation(
            @Parameter(description = "Cross-sale recommendation ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid CrossSaleRecommendationUpdateRequest updateRequest) {
        return crossSaleRecommendationService.updateCrossSaleRecommendation(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a cross-sale recommendation", description = "Deletes a cross-sale recommendation by ID")
    @ApiResponse(responseCode = "204", description = "Cross-sale recommendation deleted successfully")
    @ApiResponse(responseCode = "404", description = "Cross-sale recommendation not found")
    public void deleteCrossSaleRecommendation(
            @Parameter(description = "Cross-sale recommendation ID", required = true) @PathVariable UUID id) {
        crossSaleRecommendationService.deleteCrossSaleRecommendation(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get cross-sale recommendation by ID", description = "Retrieves detailed cross-sale recommendation information")
    @ApiResponse(responseCode = "200", description = "Cross-sale recommendation found")
    @ApiResponse(responseCode = "404", description = "Cross-sale recommendation not found")
    public CrossSaleRecommendationResponse getCrossSaleRecommendationById(
            @Parameter(description = "Cross-sale recommendation ID", required = true) @PathVariable UUID id) {
        return crossSaleRecommendationService.getCrossSaleRecommendationById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all cross-sale recommendations", description = "Retrieves a list of all cross-sale recommendations")
    @ApiResponse(responseCode = "200", description = "Cross-sale recommendations retrieved successfully")
    public List<CrossSaleRecommendationResponse> getAllCrossSaleRecommendations() {
        return crossSaleRecommendationService.getAllCrossSaleRecommendations();
    }
}