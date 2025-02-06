package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.CustomerInteractionCreateRequest;
import b2b.autosales.portal.dto.request.update.CustomerInteractionUpdateRequest;
import b2b.autosales.portal.dto.response.CustomerInteractionResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerInteractionService {

    CustomerInteractionResponse createCustomerInteraction(CustomerInteractionCreateRequest createCustomerInteractionRequest);

    CustomerInteractionResponse updateCustomerInteraction(UUID id, CustomerInteractionUpdateRequest updateCustomerInteractionRequest);

    void deleteCustomerInteraction(UUID id);

    CustomerInteractionResponse getCustomerInteractionById(UUID id);

    List<CustomerInteractionResponse> getAllCustomerInteractions();
}