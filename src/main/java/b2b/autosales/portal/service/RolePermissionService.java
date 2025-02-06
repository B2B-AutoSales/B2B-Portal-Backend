package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.RolePermissionCreateRequest;
import b2b.autosales.portal.dto.request.update.RolePermissionUpdateRequest;
import b2b.autosales.portal.dto.response.RolePermissionResponse;

import java.util.List;
import java.util.UUID;

public interface RolePermissionService {

    RolePermissionResponse createRolePermission(RolePermissionCreateRequest createRolePermissionRequest);

    RolePermissionResponse updateRolePermission(UUID id, RolePermissionUpdateRequest updateRolePermissionRequest);

    void deleteRolePermission(UUID id);

    RolePermissionResponse getRolePermissionById(UUID id);

    List<RolePermissionResponse> getAllRolePermissions();
}