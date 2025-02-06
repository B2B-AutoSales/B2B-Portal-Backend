package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.CommercialProposalCreateRequest;
import b2b.autosales.portal.dto.request.update.CommercialProposalUpdateRequest;
import b2b.autosales.portal.dto.response.CommercialProposalResponse;

import java.util.List;
import java.util.UUID;

public interface CommercialProposalService {

    CommercialProposalResponse createCommercialProposal(CommercialProposalCreateRequest createCommercialProposalRequest);

    CommercialProposalResponse updateCommercialProposal(UUID id, CommercialProposalUpdateRequest updateCommercialProposalRequest);

    void deleteCommercialProposal(UUID id);

    CommercialProposalResponse getCommercialProposalById(UUID id);

    List<CommercialProposalResponse> getAllCommercialProposals();
}