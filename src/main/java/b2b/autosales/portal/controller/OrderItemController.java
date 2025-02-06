package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.OrderItemCreateRequest;
import b2b.autosales.portal.dto.request.update.OrderItemUpdateRequest;
import b2b.autosales.portal.dto.response.OrderItemResponse;
import b2b.autosales.portal.service.OrderItemService;
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
@RequestMapping("api/v1/order-items")
@Tag(name = "Order Item Management", description = "APIs for managing order items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new order item", description = "Creates a new order item with the provided details")
    @ApiResponse(responseCode = "201", description = "Order item created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    @ApiResponse(responseCode = "404", description = "Order or product not found")
    public OrderItemResponse createOrderItem(@RequestBody @Valid OrderItemCreateRequest createRequest) {
        return orderItemService.createOrderItem(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update an order item", description = "Updates an existing order item with the provided details")
    @ApiResponse(responseCode = "200", description = "Order item updated successfully")
    @ApiResponse(responseCode = "404", description = "Order item not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public OrderItemResponse updateOrderItem(
            @Parameter(description = "Order item ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid OrderItemUpdateRequest updateRequest) {
        return orderItemService.updateOrderItem(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an order item", description = "Deletes an order item by ID")
    @ApiResponse(responseCode = "204", description = "Order item deleted successfully")
    @ApiResponse(responseCode = "404", description = "Order item not found")
    public void deleteOrderItem(@Parameter(description = "Order item ID", required = true) @PathVariable UUID id) {
        orderItemService.deleteOrderItem(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get order item by ID", description = "Retrieves detailed order item information")
    @ApiResponse(responseCode = "200", description = "Order item found")
    @ApiResponse(responseCode = "404", description = "Order item not found")
    public OrderItemResponse getOrderItemById(@Parameter(description = "Order item ID", required = true) @PathVariable UUID id) {
        return orderItemService.getOrderItemById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all order items", description = "Retrieves a list of all order items")
    @ApiResponse(responseCode = "200", description = "Order items retrieved successfully")
    public List<OrderItemResponse> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }
}