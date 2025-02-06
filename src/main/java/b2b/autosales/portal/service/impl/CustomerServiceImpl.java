package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.CustomerCreateRequest;
import b2b.autosales.portal.dto.request.update.CustomerUpdateRequest;
import b2b.autosales.portal.dto.response.CustomerResponse;
import b2b.autosales.portal.mapper.CustomerMapper;
import b2b.autosales.portal.models.Customer;
import b2b.autosales.portal.repository.CustomerRepository;
import b2b.autosales.portal.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse createCustomer(CustomerCreateRequest createCustomerRequest) {
        Customer customer = customerMapper.toCustomer(createCustomerRequest);
        return customerMapper.toCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse updateCustomer(UUID id, CustomerUpdateRequest updateCustomerRequest) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customerMapper.updateCustomerFromRequest(updateCustomerRequest, existingCustomer);
        return customerMapper.toCustomerResponse(customerRepository.save(existingCustomer));
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponse getCustomerById(UUID id) {
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerResponse)
                .toList();
    }
}