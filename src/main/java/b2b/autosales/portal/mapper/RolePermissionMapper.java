package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.RolePermission;
import b2b.autosales.portal.dto.request.create.RolePermissionCreateRequest;
import b2b.autosales.portal.dto.request.update.RolePermissionUpdateRequest;
import b2b.autosales.portal.dto.response.RolePermissionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RolePermissionMapper.class, PermissionMapper.class})
public interface RolePermissionMapper {

    RolePermissionResponse toRolePermissionResponse(RolePermission rolePermission);

    RolePermission toRolePermission(RolePermissionResponse rolePermissionResponse);

    @Mapping(target = "id", ignore = true)
    RolePermission toRolePermission(RolePermissionCreateRequest createRolePermissionRequest);

    @Mapping(target = "id", ignore = true)
    RolePermission toRolePermission(RolePermissionUpdateRequest updateRolePermissionRequest);

    @Mapping(target = "id", ignore = true)
    void updateRolePermissionFromRequest(RolePermissionUpdateRequest updateRolePermissionRequest, @MappingTarget RolePermission rolePermission);
}