package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.PermissionCreateRequest;
import b2b.autosales.portal.dto.request.update.PermissionUpdateRequest;
import b2b.autosales.portal.dto.response.PermissionResponse;

import java.util.List;
import java.util.UUID;

public interface PermissionService {

    PermissionResponse createPermission(PermissionCreateRequest createPermissionRequest);

    PermissionResponse updatePermission(UUID id, PermissionUpdateRequest updatePermissionRequest);

    void deletePermission(UUID id);

    PermissionResponse getPermissionById(UUID id);

    List<PermissionResponse> getAllPermissions();
}