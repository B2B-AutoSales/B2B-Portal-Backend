package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.CommercialProposalCreateRequest;
import b2b.autosales.portal.dto.request.update.CommercialProposalUpdateRequest;
import b2b.autosales.portal.dto.response.CommercialProposalResponse;
import b2b.autosales.portal.mapper.CommercialProposalMapper;
import b2b.autosales.portal.models.CommercialProposal;
import b2b.autosales.portal.models.Organisation;
import b2b.autosales.portal.repository.CommercialProposalRepository;
import b2b.autosales.portal.repository.OrganisationRepository;
import b2b.autosales.portal.service.CommercialProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommercialProposalServiceImpl implements CommercialProposalService {

    private final CommercialProposalRepository commercialProposalRepository;
    private final CommercialProposalMapper commercialProposalMapper;
    private final OrganisationRepository organisationRepository;

    @Override
    public CommercialProposalResponse createCommercialProposal(CommercialProposalCreateRequest createCommercialProposalRequest) {
        Organisation organisation = organisationRepository.findById(createCommercialProposalRequest.organisationId())
                .orElseThrow(() -> new RuntimeException("Organisation not found"));

        CommercialProposal commercialProposal = commercialProposalMapper.toCommercialProposal(createCommercialProposalRequest);
        commercialProposal.setOrganisation(organisation);
        return commercialProposalMapper.toCommercialProposalResponse(commercialProposalRepository.save(commercialProposal));
    }

    @Override
    public CommercialProposalResponse updateCommercialProposal(UUID id, CommercialProposalUpdateRequest updateCommercialProposalRequest) {
        CommercialProposal existingCommercialProposal = commercialProposalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CommercialProposal not found"));

        commercialProposalMapper.updateCommercialProposalFromRequest(updateCommercialProposalRequest, existingCommercialProposal);
        return commercialProposalMapper.toCommercialProposalResponse(commercialProposalRepository.save(existingCommercialProposal));
    }

    @Override
    public void deleteCommercialProposal(UUID id) {
        commercialProposalRepository.deleteById(id);
    }

    @Override
    public CommercialProposalResponse getCommercialProposalById(UUID id) {
        return commercialProposalRepository.findById(id)
                .map(commercialProposalMapper::toCommercialProposalResponse)
                .orElseThrow(() -> new RuntimeException("CommercialProposal not found"));
    }

    @Override
    public List<CommercialProposalResponse> getAllCommercialProposals() {
        return commercialProposalRepository.findAll().stream()
                .map(commercialProposalMapper::toCommercialProposalResponse)
                .toList();
    }
}