package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.Product;
import b2b.autosales.portal.dto.request.create.ProductCreateRequest;
import b2b.autosales.portal.dto.request.update.ProductUpdateRequest;
import b2b.autosales.portal.dto.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrganisationMapper.class})
public interface ProductMapper {

    ProductResponse toProductResponse(Product product);

    Product toProduct(ProductResponse productResponse);

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductCreateRequest createProductRequest);

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductUpdateRequest updateProductRequest);

    @Mapping(target = "id", ignore = true)
    void updateProductFromRequest(ProductUpdateRequest updateProductRequest, @MappingTarget Product product);
}