package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.OrderCreateRequest;
import b2b.autosales.portal.dto.request.update.OrderUpdateRequest;
import b2b.autosales.portal.dto.response.OrderResponse;
import b2b.autosales.portal.service.OrderService;
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
@RequestMapping("api/v1/orders")
@Tag(name = "Order Management", description = "APIs for managing orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new order", description = "Creates a new order with the provided details")
    @ApiResponse(responseCode = "201", description = "Order created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public OrderResponse createOrder(@RequestBody @Valid OrderCreateRequest createRequest) {
        return orderService.createOrder(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update an order", description = "Updates an existing order with the provided details")
    @ApiResponse(responseCode = "200", description = "Order updated successfully")
    @ApiResponse(responseCode = "404", description = "Order not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public OrderResponse updateOrder(
            @Parameter(description = "ID of the order to update", required = true) @PathVariable UUID id,
            @RequestBody @Valid OrderUpdateRequest updateRequest) {
        return orderService.updateOrder(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an order", description = "Deletes an order by ID")
    @ApiResponse(responseCode = "204", description = "Order deleted successfully")
    @ApiResponse(responseCode = "404", description = "Order not found")
    public void deleteOrder(@Parameter(description = "ID of the order to delete", required = true) @PathVariable UUID id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get an order by ID", description = "Retrieves an order by its ID")
    @ApiResponse(responseCode = "200", description = "Order found")
    @ApiResponse(responseCode = "404", description = "Order not found")
    public OrderResponse getOrderById(@Parameter(description = "ID of the order to retrieve", required = true) @PathVariable UUID id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all orders", description = "Retrieves a list of all orders")
    @ApiResponse(responseCode = "200", description = "List of orders retrieved successfully")
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }
}