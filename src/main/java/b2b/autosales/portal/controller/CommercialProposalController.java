package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.CommercialProposalCreateRequest;
import b2b.autosales.portal.dto.request.update.CommercialProposalUpdateRequest;
import b2b.autosales.portal.dto.response.CommercialProposalResponse;
import b2b.autosales.portal.service.CommercialProposalService;
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
@RequestMapping("api/v1/commercial-proposals")
@Tag(name = "Commercial Proposal Management", description = "APIs for managing commercial proposals")
public class CommercialProposalController {

    private final CommercialProposalService commercialProposalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new commercial proposal", description = "Creates a new commercial proposal with the provided details")
    @ApiResponse(responseCode = "201", description = "Commercial proposal created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    @ApiResponse(responseCode = "404", description = "Organisation not found")
    public CommercialProposalResponse createCommercialProposal(
            @RequestBody @Valid CommercialProposalCreateRequest createRequest) {
        return commercialProposalService.createCommercialProposal(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a commercial proposal", description = "Updates an existing commercial proposal with the provided details")
    @ApiResponse(responseCode = "200", description = "Commercial proposal updated successfully")
    @ApiResponse(responseCode = "404", description = "Commercial proposal not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public CommercialProposalResponse updateCommercialProposal(
            @Parameter(description = "Commercial proposal ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid CommercialProposalUpdateRequest updateRequest) {
        return commercialProposalService.updateCommercialProposal(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a commercial proposal", description = "Deletes a commercial proposal by ID")
    @ApiResponse(responseCode = "204", description = "Commercial proposal deleted successfully")
    @ApiResponse(responseCode = "404", description = "Commercial proposal not found")
    public void deleteCommercialProposal(
            @Parameter(description = "Commercial proposal ID", required = true) @PathVariable UUID id) {
        commercialProposalService.deleteCommercialProposal(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get commercial proposal by ID", description = "Retrieves detailed commercial proposal information")
    @ApiResponse(responseCode = "200", description = "Commercial proposal found")
    @ApiResponse(responseCode = "404", description = "Commercial proposal not found")
    public CommercialProposalResponse getCommercialProposalById(
            @Parameter(description = "Commercial proposal ID", required = true) @PathVariable UUID id) {
        return commercialProposalService.getCommercialProposalById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all commercial proposals", description = "Retrieves a list of all commercial proposals")
    @ApiResponse(responseCode = "200", description = "Commercial proposals retrieved successfully")
    public List<CommercialProposalResponse> getAllCommercialProposals() {
        return commercialProposalService.getAllCommercialProposals();
    }
}