package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.ProductCreateRequest;
import b2b.autosales.portal.dto.request.update.ProductUpdateRequest;
import b2b.autosales.portal.dto.response.ProductResponse;
import b2b.autosales.portal.mapper.ProductMapper;
import b2b.autosales.portal.models.Organisation;
import b2b.autosales.portal.models.Product;
import b2b.autosales.portal.repository.OrganisationRepository;
import b2b.autosales.portal.repository.ProductRepository;
import b2b.autosales.portal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final OrganisationRepository organisationRepository;

    @Override
    public ProductResponse createProduct(ProductCreateRequest createProductRequest) {
        Organisation organisation = organisationRepository.findById(createProductRequest.organisationId())
                .orElseThrow(() -> new RuntimeException("Organisation not found"));

        Product product = productMapper.toProduct(createProductRequest);
        product.setOrganisation(organisation);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse updateProduct(UUID id, ProductUpdateRequest updateProductRequest) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productMapper.updateProductFromRequest(updateProductRequest, existingProduct);
        return productMapper.toProductResponse(productRepository.save(existingProduct));
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponse getProductById(UUID id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .toList();
    }
}