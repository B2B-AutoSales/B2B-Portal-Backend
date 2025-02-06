package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.OrderItemCreateRequest;
import b2b.autosales.portal.dto.request.update.OrderItemUpdateRequest;
import b2b.autosales.portal.dto.response.OrderItemResponse;
import b2b.autosales.portal.mapper.OrderItemMapper;
import b2b.autosales.portal.models.Order;
import b2b.autosales.portal.models.OrderItem;
import b2b.autosales.portal.models.Product;
import b2b.autosales.portal.repository.OrderItemRepository;
import b2b.autosales.portal.repository.OrderRepository;
import b2b.autosales.portal.repository.ProductRepository;
import b2b.autosales.portal.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public OrderItemResponse createOrderItem(OrderItemCreateRequest createRequest) {
        Order order = orderRepository.findById(createRequest.orderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Product product = productRepository.findById(createRequest.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        OrderItem orderItem = orderItemMapper.toOrderItem(createRequest);
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        return orderItemMapper.toOrderItemResponse(orderItemRepository.save(orderItem));
    }

    @Override
    public OrderItemResponse updateOrderItem(UUID id, OrderItemUpdateRequest updateRequest) {
        OrderItem existingItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        orderItemMapper.updateOrderItemFromRequest(updateRequest, existingItem);
        return orderItemMapper.toOrderItemResponse(orderItemRepository.save(existingItem));
    }

    @Override
    public void deleteOrderItem(UUID id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public OrderItemResponse getOrderItemById(UUID id) {
        return orderItemRepository.findById(id)
                .map(orderItemMapper::toOrderItemResponse)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
    }

    @Override
    public List<OrderItemResponse> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(orderItemMapper::toOrderItemResponse)
                .toList();
    }
}