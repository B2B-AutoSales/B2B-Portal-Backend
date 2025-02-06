package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.TenderCreateRequest;
import b2b.autosales.portal.dto.request.update.TenderUpdateRequest;
import b2b.autosales.portal.dto.response.TenderResponse;

import java.util.List;
import java.util.UUID;

public interface TenderService {

    TenderResponse createTender(TenderCreateRequest createTenderRequest);

    TenderResponse updateTender(UUID id, TenderUpdateRequest updateTenderRequest);

    void deleteTender(UUID id);

    TenderResponse getTenderById(UUID id);

    List<TenderResponse> getAllTenders();
}