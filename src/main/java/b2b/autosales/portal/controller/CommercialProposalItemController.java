package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.CommercialProposalItemCreateRequest;
import b2b.autosales.portal.dto.request.update.CommercialProposalItemUpdateRequest;
import b2b.autosales.portal.dto.response.CommercialProposalItemResponse;
import b2b.autosales.portal.service.CommercialProposalItemService;
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
@RequestMapping("api/v1/commercial-proposal-items")
@Tag(name = "Commercial Proposal Item Management", description = "APIs for managing commercial proposal items")
public class CommercialProposalItemController {

    private final CommercialProposalItemService commercialProposalItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new commercial proposal item", description = "Creates a new commercial proposal item with the provided details")
    @ApiResponse(responseCode = "201", description = "Commercial proposal item created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    @ApiResponse(responseCode = "404", description = "Commercial proposal not found")
    public CommercialProposalItemResponse createCommercialProposalItem(
            @RequestBody @Valid CommercialProposalItemCreateRequest createRequest) {
        return commercialProposalItemService.createCommercialProposalItem(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a commercial proposal item", description = "Updates an existing commercial proposal item with the provided details")
    @ApiResponse(responseCode = "200", description = "Commercial proposal item updated successfully")
    @ApiResponse(responseCode = "404", description = "Commercial proposal item not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public CommercialProposalItemResponse updateCommercialProposalItem(
            @Parameter(description = "Commercial proposal item ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid CommercialProposalItemUpdateRequest updateRequest) {
        return commercialProposalItemService.updateCommercialProposalItem(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a commercial proposal item", description = "Deletes a commercial proposal item by ID")
    @ApiResponse(responseCode = "204", description = "Commercial proposal item deleted successfully")
    @ApiResponse(responseCode = "404", description = "Commercial proposal item not found")
    public void deleteCommercialProposalItem(
            @Parameter(description = "Commercial proposal item ID", required = true) @PathVariable UUID id) {
        commercialProposalItemService.deleteCommercialProposalItem(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get commercial proposal item by ID", description = "Retrieves detailed commercial proposal item information")
    @ApiResponse(responseCode = "200", description = "Commercial proposal item found")
    @ApiResponse(responseCode = "404", description = "Commercial proposal item not found")
    public CommercialProposalItemResponse getCommercialProposalItemById(
            @Parameter(description = "Commercial proposal item ID", required = true) @PathVariable UUID id) {
        return commercialProposalItemService.getCommercialProposalItemById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all commercial proposal items", description = "Retrieves a list of all commercial proposal items")
    @ApiResponse(responseCode = "200", description = "Commercial proposal items retrieved successfully")
    public List<CommercialProposalItemResponse> getAllCommercialProposalItems() {
        return commercialProposalItemService.getAllCommercialProposalItems();
    }
}