package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.CustomerCreateRequest;
import b2b.autosales.portal.dto.request.update.CustomerUpdateRequest;
import b2b.autosales.portal.dto.response.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerCreateRequest createCustomerRequest);

    CustomerResponse updateCustomer(UUID id, CustomerUpdateRequest updateCustomerRequest);

    void deleteCustomer(UUID id);

    CustomerResponse getCustomerById(UUID id);

    List<CustomerResponse> getAllCustomers();
}