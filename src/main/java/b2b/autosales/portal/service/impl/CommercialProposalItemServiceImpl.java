package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.CommercialProposalItemCreateRequest;
import b2b.autosales.portal.dto.request.update.CommercialProposalItemUpdateRequest;
import b2b.autosales.portal.dto.response.CommercialProposalItemResponse;
import b2b.autosales.portal.mapper.CommercialProposalItemMapper;
import b2b.autosales.portal.models.CommercialProposal;
import b2b.autosales.portal.models.CommercialProposalItem;
import b2b.autosales.portal.repository.CommercialProposalItemRepository;
import b2b.autosales.portal.repository.CommercialProposalRepository;
import b2b.autosales.portal.service.CommercialProposalItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommercialProposalItemServiceImpl implements CommercialProposalItemService {

    private final CommercialProposalItemRepository commercialProposalItemRepository;
    private final CommercialProposalItemMapper commercialProposalItemMapper;
    private final CommercialProposalRepository commercialProposalRepository;

    @Override
    public CommercialProposalItemResponse createCommercialProposalItem(CommercialProposalItemCreateRequest createCommercialProposalItemRequest) {
        CommercialProposal commercialProposal = commercialProposalRepository.findById(createCommercialProposalItemRequest.commercialProposalId())
                .orElseThrow(() -> new RuntimeException("CommercialProposal not found"));

        CommercialProposalItem commercialProposalItem = commercialProposalItemMapper.toCommercialProposalItem(createCommercialProposalItemRequest);
        commercialProposalItem.setCommercialProposal(commercialProposal);
        return commercialProposalItemMapper.toCommercialProposalItemResponse(commercialProposalItemRepository.save(commercialProposalItem));
    }

    @Override
    public CommercialProposalItemResponse updateCommercialProposalItem(UUID id, CommercialProposalItemUpdateRequest updateCommercialProposalItemRequest) {
        CommercialProposalItem existingCommercialProposalItem = commercialProposalItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CommercialProposalItem not found"));

        commercialProposalItemMapper.updateCommercialProposalItemFromRequest(updateCommercialProposalItemRequest, existingCommercialProposalItem);
        return commercialProposalItemMapper.toCommercialProposalItemResponse(commercialProposalItemRepository.save(existingCommercialProposalItem));
    }

    @Override
    public void deleteCommercialProposalItem(UUID id) {
        commercialProposalItemRepository.deleteById(id);
    }

    @Override
    public CommercialProposalItemResponse getCommercialProposalItemById(UUID id) {
        return commercialProposalItemRepository.findById(id)
                .map(commercialProposalItemMapper::toCommercialProposalItemResponse)
                .orElseThrow(() -> new RuntimeException("CommercialProposalItem not found"));
    }

    @Override
    public List<CommercialProposalItemResponse> getAllCommercialProposalItems() {
        return commercialProposalItemRepository.findAll().stream()
                .map(commercialProposalItemMapper::toCommercialProposalItemResponse)
                .toList();
    }
}