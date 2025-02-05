package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.ParserSetup;
import b2b.autosales.portal.models.dto.request.create.ParserSetupCreateRequest;
import b2b.autosales.portal.models.dto.request.update.ParserSetupUpdateRequest;
import b2b.autosales.portal.models.dto.response.ParserSetupResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrganisationMapper.class})
public interface ParserSetupMapper {

    ParserSetupResponse toParserSetupResponse(ParserSetup parserSetup);

    ParserSetup toParserSetup(ParserSetupResponse parserSetupResponse);

    @Mapping(target = "id", ignore = true)
    ParserSetup toParserSetup(ParserSetupCreateRequest createParserSetupRequest);

    @Mapping(target = "id", ignore = true)
    ParserSetup toParserSetup(ParserSetupUpdateRequest updateParserSetupRequest);

    @Mapping(target = "id", ignore = true)
    void updateParserSetupFromRequest(ParserSetupUpdateRequest updateParserSetupRequest, @MappingTarget ParserSetup parserSetup);
}