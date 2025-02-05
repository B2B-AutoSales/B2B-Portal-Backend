package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.OrderItem;
import b2b.autosales.portal.models.dto.request.create.OrderItemCreateRequest;
import b2b.autosales.portal.models.dto.request.update.OrderItemUpdateRequest;
import b2b.autosales.portal.models.dto.response.OrderItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderMapper.class, ProductMapper.class})
public interface OrderItemMapper {

    OrderItemResponse toOrderItemResponse(OrderItem orderItem);

    OrderItem toOrderItem(OrderItemResponse orderItemResponse);

    @Mapping(target = "id", ignore = true)
    OrderItem toOrderItem(OrderItemCreateRequest createOrderItemRequest);

    @Mapping(target = "id", ignore = true)
    OrderItem toOrderItem(OrderItemUpdateRequest updateOrderItemRequest);

    @Mapping(target = "id", ignore = true)
    void updateOrderItemFromRequest(OrderItemUpdateRequest updateOrderItemRequest, @MappingTarget OrderItem orderItem);
}