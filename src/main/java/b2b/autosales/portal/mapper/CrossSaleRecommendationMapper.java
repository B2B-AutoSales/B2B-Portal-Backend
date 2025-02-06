package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.CrossSaleRecommendation;
import b2b.autosales.portal.dto.request.create.CrossSaleRecommendationCreateRequest;
import b2b.autosales.portal.dto.request.update.CrossSaleRecommendationUpdateRequest;
import b2b.autosales.portal.dto.response.CrossSaleRecommendationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProductMapper.class})
public interface CrossSaleRecommendationMapper {

    CrossSaleRecommendationResponse toCrossSaleRecommendationResponse(CrossSaleRecommendation crossSaleRecommendation);

    CrossSaleRecommendation toCrossSaleRecommendation(CrossSaleRecommendationResponse crossSaleRecommendationResponse);

    @Mapping(target = "id", ignore = true)
    CrossSaleRecommendation toCrossSaleRecommendation(CrossSaleRecommendationCreateRequest createCrossSaleRecommendationRequest);

    @Mapping(target = "id", ignore = true)
    CrossSaleRecommendation toCrossSaleRecommendation(CrossSaleRecommendationUpdateRequest updateCrossSaleRecommendationRequest);

    @Mapping(target = "id", ignore = true)
    void updateCrossSaleRecommendationFromRequest(CrossSaleRecommendationUpdateRequest updateCrossSaleRecommendationRequest, @MappingTarget CrossSaleRecommendation crossSaleRecommendation);
}