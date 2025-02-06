package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.ParserSetupCreateRequest;
import b2b.autosales.portal.dto.request.update.ParserSetupUpdateRequest;
import b2b.autosales.portal.dto.response.ParserSetupResponse;

import java.util.List;
import java.util.UUID;

public interface ParserSetupService {

    ParserSetupResponse createParserSetup(ParserSetupCreateRequest createParserSetupRequest);

    ParserSetupResponse updateParserSetup(UUID id, ParserSetupUpdateRequest updateParserSetupRequest);

    void deleteParserSetup(UUID id);

    ParserSetupResponse getParserSetupById(UUID id);

    List<ParserSetupResponse> getAllParserSetups();
}