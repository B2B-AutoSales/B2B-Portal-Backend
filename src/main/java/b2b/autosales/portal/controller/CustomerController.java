package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.CustomerCreateRequest;
import b2b.autosales.portal.dto.request.update.CustomerUpdateRequest;
import b2b.autosales.portal.dto.response.CustomerResponse;
import b2b.autosales.portal.service.CustomerService;
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
@RequestMapping("api/v1/customers")
@Tag(name = "Customer Management", description = "APIs for managing customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new customer", description = "Creates a new customer with the provided details")
    @ApiResponse(responseCode = "201", description = "Customer created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public CustomerResponse createCustomer(@RequestBody @Valid CustomerCreateRequest createRequest) {
        return customerService.createCustomer(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a customer", description = "Updates an existing customer with the provided details")
    @ApiResponse(responseCode = "200", description = "Customer updated successfully")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public CustomerResponse updateCustomer(
            @Parameter(description = "Customer ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid CustomerUpdateRequest updateRequest) {
        return customerService.updateCustomer(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a customer", description = "Deletes a customer by ID")
    @ApiResponse(responseCode = "204", description = "Customer deleted successfully")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    public void deleteCustomer(
            @Parameter(description = "Customer ID", required = true) @PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get customer by ID", description = "Retrieves detailed customer information")
    @ApiResponse(responseCode = "200", description = "Customer found")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    public CustomerResponse getCustomerById(
            @Parameter(description = "Customer ID", required = true) @PathVariable UUID id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all customers", description = "Retrieves a list of all customers")
    @ApiResponse(responseCode = "200", description = "Customers retrieved successfully")
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}