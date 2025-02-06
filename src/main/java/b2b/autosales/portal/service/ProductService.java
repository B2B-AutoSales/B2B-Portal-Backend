package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.ProductCreateRequest;
import b2b.autosales.portal.dto.request.update.ProductUpdateRequest;
import b2b.autosales.portal.dto.response.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponse createProduct(ProductCreateRequest createProductRequest);

    ProductResponse updateProduct(UUID id, ProductUpdateRequest updateProductRequest);

    void deleteProduct(UUID id);

    ProductResponse getProductById(UUID id);

    List<ProductResponse> getAllProducts();
}