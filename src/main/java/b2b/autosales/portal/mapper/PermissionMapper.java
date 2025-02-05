package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.Permission;
import b2b.autosales.portal.models.dto.request.create.PermissionCreateRequest;
import b2b.autosales.portal.models.dto.request.update.PermissionUpdateRequest;
import b2b.autosales.portal.models.dto.response.PermissionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermissionMapper {

    PermissionResponse toPermissionResponse(Permission permission);

    Permission toPermission(PermissionResponse permissionResponse);

    @Mapping(target = "id", ignore = true)
    Permission toPermission(PermissionCreateRequest createPermissionRequest);

    @Mapping(target = "id", ignore = true)
    Permission toPermission(PermissionUpdateRequest updatePermissionRequest);

    @Mapping(target = "id", ignore = true)
    void updatePermissionFromRequest(PermissionUpdateRequest updatePermissionRequest, @MappingTarget Permission permission);
}