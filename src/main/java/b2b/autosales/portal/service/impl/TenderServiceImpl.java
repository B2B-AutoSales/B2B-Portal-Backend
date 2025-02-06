package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.TenderCreateRequest;
import b2b.autosales.portal.dto.request.update.TenderUpdateRequest;
import b2b.autosales.portal.dto.response.TenderResponse;
import b2b.autosales.portal.mapper.TenderMapper;
import b2b.autosales.portal.models.Tender;
import b2b.autosales.portal.repository.TenderRepository;
import b2b.autosales.portal.service.TenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TenderServiceImpl implements TenderService {

    private final TenderRepository tenderRepository;
    private final TenderMapper tenderMapper;

    @Override
    public TenderResponse createTender(TenderCreateRequest createTenderRequest) {
        Tender tender = tenderMapper.toTender(createTenderRequest);
        return tenderMapper.toTenderResponse(tenderRepository.save(tender));
    }

    @Override
    public TenderResponse updateTender(UUID id, TenderUpdateRequest updateTenderRequest) {
        Tender existingTender = tenderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tender not found"));

        tenderMapper.updateTenderFromRequest(updateTenderRequest, existingTender);
        return tenderMapper.toTenderResponse(tenderRepository.save(existingTender));
    }

    @Override
    public void deleteTender(UUID id) {
        tenderRepository.deleteById(id);
    }

    @Override
    public TenderResponse getTenderById(UUID id) {
        return tenderRepository.findById(id)
                .map(tenderMapper::toTenderResponse)
                .orElseThrow(() -> new RuntimeException("Tender not found"));
    }

    @Override
    public List<TenderResponse> getAllTenders() {
        return tenderRepository.findAll().stream()
                .map(tenderMapper::toTenderResponse)
                .toList();
    }
}