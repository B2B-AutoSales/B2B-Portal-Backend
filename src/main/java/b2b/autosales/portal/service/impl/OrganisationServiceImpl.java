package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.OrganisationCreateRequest;
import b2b.autosales.portal.dto.request.update.OrganisationUpdateRequest;
import b2b.autosales.portal.dto.response.OrganisationResponse;
import b2b.autosales.portal.mapper.OrganisationMapper;
import b2b.autosales.portal.models.Organisation;
import b2b.autosales.portal.repository.OrganisationRepository;
import b2b.autosales.portal.service.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationRepository organisationRepository;
    private final OrganisationMapper organisationMapper;

    @Override
    public OrganisationResponse createOrganisation(OrganisationCreateRequest createOrganisationRequest) {
        Organisation organisation = organisationMapper.toOrganisation(createOrganisationRequest);
        return organisationMapper.toOrganisationResponse(organisationRepository.save(organisation));
    }

    @Override
    public OrganisationResponse updateOrganisation(UUID id, OrganisationUpdateRequest updateOrganisationRequest) {
        Organisation existingOrganisation = organisationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organisation not found"));

        organisationMapper.updateOrganisationFromRequest(updateOrganisationRequest, existingOrganisation);
        return organisationMapper.toOrganisationResponse(organisationRepository.save(existingOrganisation));
    }

    @Override
    public void deleteOrganisation(UUID id) {
        organisationRepository.deleteById(id);
    }

    @Override
    public OrganisationResponse getOrganisationById(UUID id) {
        return organisationRepository.findById(id)
                .map(organisationMapper::toOrganisationResponse)
                .orElseThrow(() -> new RuntimeException("Organisation not found"));
    }

    @Override
    public List<OrganisationResponse> getAllOrganisations() {
        return organisationRepository.findAll().stream()
                .map(organisationMapper::toOrganisationResponse)
                .toList();
    }
}