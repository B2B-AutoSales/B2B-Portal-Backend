package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.ProductCreateRequest;
import b2b.autosales.portal.dto.request.update.ProductUpdateRequest;
import b2b.autosales.portal.dto.response.ProductResponse;
import b2b.autosales.portal.service.ProductService;
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
@RequestMapping("api/v1/products")
@Tag(name = "Product Management", description = "APIs for managing products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new product", description = "Creates a new product with the provided details")
    @ApiResponse(responseCode = "201", description = "Product created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public ProductResponse createProduct(@RequestBody @Valid ProductCreateRequest createRequest) {
        return productService.createProduct(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a product", description = "Updates an existing product with the provided details")
    @ApiResponse(responseCode = "200", description = "Product updated successfully")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public ProductResponse updateProduct(
            @Parameter(description = "ID of the product to update", required = true) @PathVariable UUID id,
            @RequestBody @Valid ProductUpdateRequest updateRequest) {
        return productService.updateProduct(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a product", description = "Deletes a product by ID")
    @ApiResponse(responseCode = "204", description = "Product deleted successfully")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public void deleteProduct(@Parameter(description = "ID of the product to delete", required = true) @PathVariable UUID id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a product by ID", description = "Retrieves a product by its ID")
    @ApiResponse(responseCode = "200", description = "Product found")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public ProductResponse getProductById(@Parameter(description = "ID of the product to retrieve", required = true) @PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all products", description = "Retrieves a list of all products")
    @ApiResponse(responseCode = "200", description = "List of products retrieved successfully")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}