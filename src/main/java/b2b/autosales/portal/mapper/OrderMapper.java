package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.Order;
import b2b.autosales.portal.models.dto.request.create.OrderCreateRequest;
import b2b.autosales.portal.models.dto.request.update.OrderUpdateRequest;
import b2b.autosales.portal.models.dto.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, OrganisationMapper.class})
public interface OrderMapper {

    OrderResponse toOrderResponse(Order order);

    Order toOrder(OrderResponse orderResponse);

    @Mapping(target = "id", ignore = true)
    Order toOrder(OrderCreateRequest createOrderRequest);

    @Mapping(target = "id", ignore = true)
    Order toOrder(OrderUpdateRequest updateOrderRequest);

    @Mapping(target = "id", ignore = true)
    void updateOrderFromRequest(OrderUpdateRequest updateOrderRequest, @MappingTarget Order order);
}