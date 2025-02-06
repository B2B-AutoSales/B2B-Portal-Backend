package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.CustomerInteractionCreateRequest;
import b2b.autosales.portal.dto.request.update.CustomerInteractionUpdateRequest;
import b2b.autosales.portal.dto.response.CustomerInteractionResponse;
import b2b.autosales.portal.service.CustomerInteractionService;
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
@RequestMapping("api/v1/customer-interactions")
@Tag(name = "Customer Interaction Management", description = "APIs for managing customer interactions")
public class CustomerInteractionController {

    private final CustomerInteractionService customerInteractionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new customer interaction", description = "Creates a new customer interaction with the provided details")
    @ApiResponse(responseCode = "201", description = "Customer interaction created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    public CustomerInteractionResponse createCustomerInteraction(
            @RequestBody @Valid CustomerInteractionCreateRequest createRequest) {
        return customerInteractionService.createCustomerInteraction(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a customer interaction", description = "Updates an existing customer interaction with the provided details")
    @ApiResponse(responseCode = "200", description = "Customer interaction updated successfully")
    @ApiResponse(responseCode = "404", description = "Customer interaction not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public CustomerInteractionResponse updateCustomerInteraction(
            @Parameter(description = "Customer interaction ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid CustomerInteractionUpdateRequest updateRequest) {
        return customerInteractionService.updateCustomerInteraction(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a customer interaction", description = "Deletes a customer interaction by ID")
    @ApiResponse(responseCode = "204", description = "Customer interaction deleted successfully")
    @ApiResponse(responseCode = "404", description = "Customer interaction not found")
    public void deleteCustomerInteraction(
            @Parameter(description = "Customer interaction ID", required = true) @PathVariable UUID id) {
        customerInteractionService.deleteCustomerInteraction(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get customer interaction by ID", description = "Retrieves detailed customer interaction information")
    @ApiResponse(responseCode = "200", description = "Customer interaction found")
    @ApiResponse(responseCode = "404", description = "Customer interaction not found")
    public CustomerInteractionResponse getCustomerInteractionById(
            @Parameter(description = "Customer interaction ID", required = true) @PathVariable UUID id) {
        return customerInteractionService.getCustomerInteractionById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all customer interactions", description = "Retrieves a list of all customer interactions")
    @ApiResponse(responseCode = "200", description = "Customer interactions retrieved successfully")
    public List<CustomerInteractionResponse> getAllCustomerInteractions() {
        return customerInteractionService.getAllCustomerInteractions();
    }
}