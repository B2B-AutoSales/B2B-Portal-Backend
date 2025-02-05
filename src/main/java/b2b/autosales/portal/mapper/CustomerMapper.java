package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.Customer;
import b2b.autosales.portal.models.dto.request.create.CustomerCreateRequest;
import b2b.autosales.portal.models.dto.request.update.CustomerUpdateRequest;
import b2b.autosales.portal.models.dto.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrganisationMapper.class})
public interface CustomerMapper {

    CustomerResponse toCustomerResponse(Customer customer);

    Customer toCustomer(CustomerResponse customerResponse);

    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerCreateRequest createCustomerRequest);

    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerUpdateRequest updateCustomerRequest);

    @Mapping(target = "id", ignore = true)
    void updateCustomerFromRequest(CustomerUpdateRequest updateCustomerRequest, @MappingTarget Customer customer);
}