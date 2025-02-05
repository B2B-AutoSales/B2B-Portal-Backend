package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.CustomerInteraction;
import b2b.autosales.portal.models.dto.request.create.CustomerInteractionCreateRequest;
import b2b.autosales.portal.models.dto.request.update.CustomerInteractionUpdateRequest;
import b2b.autosales.portal.models.dto.response.CustomerInteractionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CustomerMapper.class, UserMapper.class})
public interface CustomerInteractionMapper {

    CustomerInteractionResponse toCustomerInteractionResponse(CustomerInteraction customerInteraction);

    CustomerInteraction toCustomerInteraction(CustomerInteractionResponse customerInteractionResponse);

    @Mapping(target = "id", ignore = true)
    CustomerInteraction toCustomerInteraction(CustomerInteractionCreateRequest createCustomerInteractionRequest);

    @Mapping(target = "id", ignore = true)
    CustomerInteraction toCustomerInteraction(CustomerInteractionUpdateRequest updateCustomerInteractionRequest);

    @Mapping(target = "id", ignore = true)
    void updateCustomerInteractionFromRequest(CustomerInteractionUpdateRequest updateCustomerInteractionRequest, @MappingTarget CustomerInteraction customerInteraction);
}