package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.CustomerInteractionCreateRequest;
import b2b.autosales.portal.dto.request.update.CustomerInteractionUpdateRequest;
import b2b.autosales.portal.dto.response.CustomerInteractionResponse;
import b2b.autosales.portal.mapper.CustomerInteractionMapper;
import b2b.autosales.portal.models.Customer;
import b2b.autosales.portal.models.CustomerInteraction;
import b2b.autosales.portal.repository.CustomerInteractionRepository;
import b2b.autosales.portal.repository.CustomerRepository;
import b2b.autosales.portal.service.CustomerInteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerInteractionServiceImpl implements CustomerInteractionService {

    private final CustomerInteractionRepository customerInteractionRepository;
    private final CustomerInteractionMapper customerInteractionMapper;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerInteractionResponse createCustomerInteraction(CustomerInteractionCreateRequest createCustomerInteractionRequest) {
        Customer customer = customerRepository.findById(createCustomerInteractionRequest.customerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerInteraction customerInteraction = customerInteractionMapper.toCustomerInteraction(createCustomerInteractionRequest);
        customerInteraction.setCustomer(customer);
        return customerInteractionMapper.toCustomerInteractionResponse(customerInteractionRepository.save(customerInteraction));
    }

    @Override
    public CustomerInteractionResponse updateCustomerInteraction(UUID id, CustomerInteractionUpdateRequest updateCustomerInteractionRequest) {
        CustomerInteraction existingCustomerInteraction = customerInteractionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerInteraction not found"));

        customerInteractionMapper.updateCustomerInteractionFromRequest(updateCustomerInteractionRequest, existingCustomerInteraction);
        return customerInteractionMapper.toCustomerInteractionResponse(customerInteractionRepository.save(existingCustomerInteraction));
    }

    @Override
    public void deleteCustomerInteraction(UUID id) {
        customerInteractionRepository.deleteById(id);
    }

    @Override
    public CustomerInteractionResponse getCustomerInteractionById(UUID id) {
        return customerInteractionRepository.findById(id)
                .map(customerInteractionMapper::toCustomerInteractionResponse)
                .orElseThrow(() -> new RuntimeException("CustomerInteraction not found"));
    }

    @Override
    public List<CustomerInteractionResponse> getAllCustomerInteractions() {
        return customerInteractionRepository.findAll().stream()
                .map(customerInteractionMapper::toCustomerInteractionResponse)
                .toList();
    }
}