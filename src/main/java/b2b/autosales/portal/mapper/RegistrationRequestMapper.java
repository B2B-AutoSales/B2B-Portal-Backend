package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.RegistrationRequest;
import b2b.autosales.portal.models.dto.request.create.RegistrationRequestCreateRequest;
import b2b.autosales.portal.models.dto.request.update.RegistrationRequestUpdateRequest;
import b2b.autosales.portal.models.dto.response.RegistrationRequestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegistrationRequestMapper {

    RegistrationRequestResponse toRegistrationRequestResponse(RegistrationRequest registrationRequest);

    RegistrationRequest toRegistrationRequest(RegistrationRequestResponse registrationRequestResponse);

    @Mapping(target = "id", ignore = true)
    RegistrationRequest toRegistrationRequest(RegistrationRequestCreateRequest createRegistrationRequestRequest);

    @Mapping(target = "id", ignore = true)
    RegistrationRequest toRegistrationRequest(RegistrationRequestUpdateRequest updateRegistrationRequestRequest);

    @Mapping(target = "id", ignore = true)
    void updateRegistrationRequestFromRequest(RegistrationRequestUpdateRequest updateRegistrationRequestRequest, @MappingTarget RegistrationRequest registrationRequest);
}