package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.CrossSaleRecommendationCreateRequest;
import b2b.autosales.portal.dto.request.update.CrossSaleRecommendationUpdateRequest;
import b2b.autosales.portal.dto.response.CommercialProposalResponse;
import b2b.autosales.portal.dto.response.CrossSaleRecommendationResponse;
import b2b.autosales.portal.mapper.CrossSaleRecommendationMapper;
import b2b.autosales.portal.models.CrossSaleRecommendation;
import b2b.autosales.portal.models.Product;
import b2b.autosales.portal.repository.CrossSaleRecommendationRepository;
import b2b.autosales.portal.repository.ProductRepository;
import b2b.autosales.portal.service.CrossSaleRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CrossSaleRecommendationServiceImpl implements CrossSaleRecommendationService {

    private final CrossSaleRecommendationRepository crossSaleRecommendationRepository;
    private final CrossSaleRecommendationMapper crossSaleRecommendationMapper;
    private final ProductRepository productRepository;

    @Override
    public CrossSaleRecommendationResponse createCrossSaleRecommendation(CrossSaleRecommendationCreateRequest createCrossSaleRecommendationRequest) {
        Product product = productRepository.findById(createCrossSaleRecommendationRequest.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CrossSaleRecommendation crossSaleRecommendation = crossSaleRecommendationMapper.toCrossSaleRecommendation(createCrossSaleRecommendationRequest);
        crossSaleRecommendation.setProduct(product);
        return crossSaleRecommendationMapper.toCrossSaleRecommendationResponse(crossSaleRecommendationRepository.save(crossSaleRecommendation));
    }

    @Override
    public CrossSaleRecommendationResponse updateCrossSaleRecommendation(UUID id, CrossSaleRecommendationUpdateRequest updateCrossSaleRecommendationRequest) {
        CrossSaleRecommendation existingCrossSaleRecommendation = crossSaleRecommendationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CrossSaleRecommendation not found"));

        crossSaleRecommendationMapper.updateCrossSaleRecommendationFromRequest(updateCrossSaleRecommendationRequest, existingCrossSaleRecommendation);
        return crossSaleRecommendationMapper.toCrossSaleRecommendationResponse(crossSaleRecommendationRepository.save(existingCrossSaleRecommendation));
    }

    @Override
    public void deleteCrossSaleRecommendation(UUID id) {
        crossSaleRecommendationRepository.deleteById(id);
    }

    @Override
    public CrossSaleRecommendationResponse getCrossSaleRecommendationById(UUID id) {
        return crossSaleRecommendationRepository.findById(id)
                .map(crossSaleRecommendationMapper::toCrossSaleRecommendationResponse)
                .orElseThrow(() -> new RuntimeException("crossSaleRecommendation not found"));
    }

    @Override
    public List<CrossSaleRecommendationResponse> getAllCrossSaleRecommendations() {
        return crossSaleRecommendationRepository.findAll().stream().map(crossSaleRecommendationMapper::toCrossSaleRecommendationResponse)
                .toList();
    }

}