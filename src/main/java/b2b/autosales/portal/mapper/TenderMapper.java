package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.Tender;
import b2b.autosales.portal.dto.request.create.TenderCreateRequest;
import b2b.autosales.portal.dto.request.update.TenderUpdateRequest;
import b2b.autosales.portal.dto.response.TenderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrganisationMapper.class})
public interface TenderMapper {

    TenderResponse toTenderResponse(Tender tender);

    Tender toTender(TenderResponse tenderResponse);

    @Mapping(target = "id", ignore = true)
    Tender toTender(TenderCreateRequest createTenderRequest);

    @Mapping(target = "id", ignore = true)
    Tender toTender(TenderUpdateRequest updateTenderRequest);

    @Mapping(target = "id", ignore = true)
    void updateTenderFromRequest(TenderUpdateRequest updateTenderRequest, @MappingTarget Tender tender);
}