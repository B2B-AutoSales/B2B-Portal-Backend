package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.ParserSetupCreateRequest;
import b2b.autosales.portal.dto.request.update.ParserSetupUpdateRequest;
import b2b.autosales.portal.dto.response.ParserSetupResponse;
import b2b.autosales.portal.mapper.ParserSetupMapper;
import b2b.autosales.portal.models.Organisation;
import b2b.autosales.portal.models.ParserSetup;
import b2b.autosales.portal.repository.OrganisationRepository;
import b2b.autosales.portal.repository.ParserSetupRepository;
import b2b.autosales.portal.service.ParserSetupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParserSetupServiceImpl implements ParserSetupService {

    private final ParserSetupRepository parserSetupRepository;
    private final ParserSetupMapper parserSetupMapper;
    private final OrganisationRepository organisationRepository;

    @Override
    public ParserSetupResponse createParserSetup(ParserSetupCreateRequest createRequest) {
        Organisation organisation = organisationRepository.findById(createRequest.organisationId())
                .orElseThrow(() -> new RuntimeException("Organisation not found"));

        ParserSetup parserSetup = parserSetupMapper.toParserSetup(createRequest);
        parserSetup.setOrganisation(organisation);
        return parserSetupMapper.toParserSetupResponse(parserSetupRepository.save(parserSetup));
    }

    @Override
    public ParserSetupResponse updateParserSetup(UUID id, ParserSetupUpdateRequest updateRequest) {
        ParserSetup existingSetup = parserSetupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParserSetup not found"));

        parserSetupMapper.updateParserSetupFromRequest(updateRequest, existingSetup);
        return parserSetupMapper.toParserSetupResponse(parserSetupRepository.save(existingSetup));
    }

    @Override
    public void deleteParserSetup(UUID id) {
        parserSetupRepository.deleteById(id);
    }

    @Override
    public ParserSetupResponse getParserSetupById(UUID id) {
        return parserSetupRepository.findById(id)
                .map(parserSetupMapper::toParserSetupResponse)
                .orElseThrow(() -> new RuntimeException("ParserSetup not found"));
    }

    @Override
    public List<ParserSetupResponse> getAllParserSetups() {
        return parserSetupRepository.findAll().stream()
                .map(parserSetupMapper::toParserSetupResponse)
                .toList();
    }
}