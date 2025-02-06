package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.CrossSaleRecommendationCreateRequest;
import b2b.autosales.portal.dto.request.update.CrossSaleRecommendationUpdateRequest;
import b2b.autosales.portal.dto.response.CrossSaleRecommendationResponse;

import java.util.List;
import java.util.UUID;

public interface CrossSaleRecommendationService {

    CrossSaleRecommendationResponse createCrossSaleRecommendation(CrossSaleRecommendationCreateRequest createCrossSaleRecommendationRequest);

    CrossSaleRecommendationResponse updateCrossSaleRecommendation(UUID id, CrossSaleRecommendationUpdateRequest updateCrossSaleRecommendationRequest);

    void deleteCrossSaleRecommendation(UUID id);

    CrossSaleRecommendationResponse getCrossSaleRecommendationById(UUID id);

    List<CrossSaleRecommendationResponse> getAllCrossSaleRecommendations();
}