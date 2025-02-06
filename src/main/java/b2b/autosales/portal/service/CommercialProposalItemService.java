package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.CommercialProposalItemCreateRequest;
import b2b.autosales.portal.dto.request.update.CommercialProposalItemUpdateRequest;
import b2b.autosales.portal.dto.response.CommercialProposalItemResponse;

import java.util.List;
import java.util.UUID;

public interface CommercialProposalItemService {

    CommercialProposalItemResponse createCommercialProposalItem(CommercialProposalItemCreateRequest createCommercialProposalItemRequest);

    CommercialProposalItemResponse updateCommercialProposalItem(UUID id, CommercialProposalItemUpdateRequest updateCommercialProposalItemRequest);

    void deleteCommercialProposalItem(UUID id);

    CommercialProposalItemResponse getCommercialProposalItemById(UUID id);

    List<CommercialProposalItemResponse> getAllCommercialProposalItems();
}