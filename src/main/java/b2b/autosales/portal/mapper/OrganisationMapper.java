package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.Organisation;
import b2b.autosales.portal.models.dto.request.create.OrganisationCreateRequest;
import b2b.autosales.portal.models.dto.request.update.OrganisationUpdateRequest;
import b2b.autosales.portal.models.dto.response.OrganisationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganisationMapper {

    OrganisationResponse toOrganisationResponse(Organisation organisation);

    Organisation toOrganisation(OrganisationResponse organisationResponse);

    @Mapping(target = "id", ignore = true)
    Organisation toOrganisation(OrganisationCreateRequest createOrganisationRequest);

    @Mapping(target = "id", ignore = true)
    Organisation toOrganisation(OrganisationUpdateRequest updateOrganisationRequest);

    @Mapping(target = "id", ignore = true)
    void updateOrganisationFromRequest(OrganisationUpdateRequest updateOrganisationRequest, @MappingTarget Organisation organisation);
}