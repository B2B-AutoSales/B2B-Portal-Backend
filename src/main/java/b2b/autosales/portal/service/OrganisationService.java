package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.OrganisationCreateRequest;
import b2b.autosales.portal.dto.request.update.OrganisationUpdateRequest;
import b2b.autosales.portal.dto.response.OrganisationResponse;

import java.util.List;
import java.util.UUID;

public interface OrganisationService {

    OrganisationResponse createOrganisation(OrganisationCreateRequest createOrganisationRequest);

    OrganisationResponse updateOrganisation(UUID id, OrganisationUpdateRequest updateOrganisationRequest);

    void deleteOrganisation(UUID id);

    OrganisationResponse getOrganisationById(UUID id);

    List<OrganisationResponse> getAllOrganisations();
}