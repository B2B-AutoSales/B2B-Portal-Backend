package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.OrganisationCreateRequest;
import b2b.autosales.portal.dto.request.update.OrganisationUpdateRequest;
import b2b.autosales.portal.dto.response.OrganisationResponse;
import b2b.autosales.portal.service.OrganisationService;
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
@RequestMapping("api/v1/organisations")
@Tag(name = "Organisation Management", description = "APIs for managing organisations")
public class OrganisationController {

    private final OrganisationService organisationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new organisation", description = "Creates a new organisation with the provided details")
    @ApiResponse(responseCode = "201", description = "Organisation created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public OrganisationResponse createOrganisation(@RequestBody @Valid OrganisationCreateRequest createRequest) {
        return organisationService.createOrganisation(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update an organisation", description = "Updates an existing organisation with the provided details")
    @ApiResponse(responseCode = "200", description = "Organisation updated successfully")
    @ApiResponse(responseCode = "404", description = "Organisation not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public OrganisationResponse updateOrganisation(
            @Parameter(description = "ID of the organisation to update", required = true) @PathVariable UUID id,
            @RequestBody @Valid OrganisationUpdateRequest updateRequest) {
        return organisationService.updateOrganisation(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an organisation", description = "Deletes an organisation by ID")
    @ApiResponse(responseCode = "204", description = "Organisation deleted successfully")
    @ApiResponse(responseCode = "404", description = "Organisation not found")
    public void deleteOrganisation(@Parameter(description = "ID of the organisation to delete", required = true) @PathVariable UUID id) {
        organisationService.deleteOrganisation(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get an organisation by ID", description = "Retrieves an organisation by its ID")
    @ApiResponse(responseCode = "200", description = "Organisation found")
    @ApiResponse(responseCode = "404", description = "Organisation not found")
    public OrganisationResponse getOrganisationById(@Parameter(description = "ID of the organisation to retrieve", required = true) @PathVariable UUID id) {
        return organisationService.getOrganisationById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all organisations", description = "Retrieves a list of all organisations")
    @ApiResponse(responseCode = "200", description = "List of organisations retrieved successfully")
    public List<OrganisationResponse> getAllOrganisations() {
        return organisationService.getAllOrganisations();
    }
}