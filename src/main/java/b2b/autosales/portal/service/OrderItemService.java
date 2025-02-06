package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.OrderItemCreateRequest;
import b2b.autosales.portal.dto.request.update.OrderItemUpdateRequest;
import b2b.autosales.portal.dto.response.OrderItemResponse;

import java.util.List;
import java.util.UUID;

public interface OrderItemService {

    OrderItemResponse createOrderItem(OrderItemCreateRequest createOrderItemRequest);

    OrderItemResponse updateOrderItem(UUID id, OrderItemUpdateRequest updateOrderItemRequest);

    void deleteOrderItem(UUID id);

    OrderItemResponse getOrderItemById(UUID id);

    List<OrderItemResponse> getAllOrderItems();
}