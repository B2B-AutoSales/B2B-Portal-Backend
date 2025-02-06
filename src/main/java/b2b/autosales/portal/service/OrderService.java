package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.OrderCreateRequest;
import b2b.autosales.portal.dto.request.update.OrderUpdateRequest;
import b2b.autosales.portal.dto.response.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    OrderResponse createOrder(OrderCreateRequest createOrderRequest);

    OrderResponse updateOrder(UUID id, OrderUpdateRequest updateOrderRequest);

    void deleteOrder(UUID id);

    OrderResponse getOrderById(UUID id);

    List<OrderResponse> getAllOrders();
}