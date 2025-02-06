package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.OrderCreateRequest;
import b2b.autosales.portal.dto.request.update.OrderUpdateRequest;
import b2b.autosales.portal.dto.response.OrderResponse;
import b2b.autosales.portal.mapper.OrderMapper;
import b2b.autosales.portal.models.Order;
import b2b.autosales.portal.models.Organisation;
import b2b.autosales.portal.models.User;
import b2b.autosales.portal.repository.OrderRepository;
import b2b.autosales.portal.repository.OrganisationRepository;
import b2b.autosales.portal.repository.UserRepository;
import b2b.autosales.portal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;
    private final OrganisationRepository organisationRepository;

    @Override
    public OrderResponse createOrder(OrderCreateRequest createOrderRequest) {
        User user = userRepository.findById(createOrderRequest.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Organisation organisation = organisationRepository.findById(createOrderRequest.organisationId())
                .orElseThrow(() -> new RuntimeException("Organisation not found"));

        Order order = orderMapper.toOrder(createOrderRequest);
        order.setUser(user);
        order.setOrganisation(organisation);
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse updateOrder(UUID id, OrderUpdateRequest updateOrderRequest) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        orderMapper.updateOrderFromRequest(updateOrderRequest, existingOrder);
        return orderMapper.toOrderResponse(orderRepository.save(existingOrder));
    }

    @Override
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderResponse getOrderById(UUID id) {
        return orderRepository.findById(id)
                .map(orderMapper::toOrderResponse)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }
}