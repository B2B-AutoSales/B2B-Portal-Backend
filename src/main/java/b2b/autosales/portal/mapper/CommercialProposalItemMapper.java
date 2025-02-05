package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.CommercialProposalItem;
import b2b.autosales.portal.models.dto.request.create.CommercialProposalItemCreateRequest;
import b2b.autosales.portal.models.dto.request.update.CommercialProposalItemUpdateRequest;
import b2b.autosales.portal.models.dto.response.CommercialProposalItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CommercialProposalMapper.class, ProductMapper.class})
public interface CommercialProposalItemMapper {

    CommercialProposalItemResponse toCommercialProposalItemResponse(CommercialProposalItem commercialProposalItem);

    CommercialProposalItem toCommercialProposalItem(CommercialProposalItemResponse commercialProposalItemResponse);

    @Mapping(target = "id", ignore = true)
    CommercialProposalItem toCommercialProposalItem(CommercialProposalItemCreateRequest createCommercialProposalItemRequest);

    @Mapping(target = "id", ignore = true)
    CommercialProposalItem toCommercialProposalItem(CommercialProposalItemUpdateRequest updateCommercialProposalItemRequest);

    @Mapping(target = "id", ignore = true)
    void updateCommercialProposalItemFromRequest(CommercialProposalItemUpdateRequest updateCommercialProposalItemRequest, @MappingTarget CommercialProposalItem commercialProposalItem);
}