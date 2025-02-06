package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.TenderCreateRequest;
import b2b.autosales.portal.dto.request.update.TenderUpdateRequest;
import b2b.autosales.portal.dto.response.TenderResponse;
import b2b.autosales.portal.service.TenderService;
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
@RequestMapping("api/v1/tenders")
@Tag(name = "Tender Management", description = "APIs for managing tenders")
public class TenderController {

    private final TenderService tenderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new tender", description = "Creates a new tender with the provided details")
    @ApiResponse(responseCode = "201", description = "Tender created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public TenderResponse createTender(@RequestBody @Valid TenderCreateRequest createRequest) {
        return tenderService.createTender(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a tender", description = "Updates an existing tender with the provided details")
    @ApiResponse(responseCode = "200", description = "Tender updated successfully")
    @ApiResponse(responseCode = "404", description = "Tender not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public TenderResponse updateTender(
            @Parameter(description = "ID of the tender to update", required = true) @PathVariable UUID id,
            @RequestBody @Valid TenderUpdateRequest updateRequest) {
        return tenderService.updateTender(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a tender", description = "Deletes a tender by ID")
    @ApiResponse(responseCode = "204", description = "Tender deleted successfully")
    @ApiResponse(responseCode = "404", description = "Tender not found")
    public void deleteTender(@Parameter(description = "ID of the tender to delete", required = true) @PathVariable UUID id) {
        tenderService.deleteTender(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a tender by ID", description = "Retrieves a tender by its ID")
    @ApiResponse(responseCode = "200", description = "Tender found")
    @ApiResponse(responseCode = "404", description = "Tender not found")
    public TenderResponse getTenderById(@Parameter(description = "ID of the tender to retrieve", required = true) @PathVariable UUID id) {
        return tenderService.getTenderById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all tenders", description = "Retrieves a list of all tenders")
    @ApiResponse(responseCode = "200", description = "List of tenders retrieved successfully")
    public List<TenderResponse> getAllTenders() {
        return tenderService.getAllTenders();
    }
}