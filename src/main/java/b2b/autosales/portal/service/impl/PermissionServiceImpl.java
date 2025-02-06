package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.PermissionCreateRequest;
import b2b.autosales.portal.dto.request.update.PermissionUpdateRequest;
import b2b.autosales.portal.dto.response.PermissionResponse;
import b2b.autosales.portal.mapper.PermissionMapper;
import b2b.autosales.portal.models.Permission;
import b2b.autosales.portal.repository.PermissionRepository;
import b2b.autosales.portal.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public PermissionResponse createPermission(PermissionCreateRequest createPermissionRequest) {
        Permission permission = permissionMapper.toPermission(createPermissionRequest);
        return permissionMapper.toPermissionResponse(permissionRepository.save(permission));
    }

    @Override
    public PermissionResponse updatePermission(UUID id, PermissionUpdateRequest updatePermissionRequest) {
        Permission existingPermission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        permissionMapper.updatePermissionFromRequest(updatePermissionRequest, existingPermission);
        return permissionMapper.toPermissionResponse(permissionRepository.save(existingPermission));
    }

    @Override
    public void deletePermission(UUID id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public PermissionResponse getPermissionById(UUID id) {
        return permissionRepository.findById(id)
                .map(permissionMapper::toPermissionResponse)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
    }

    @Override
    public List<PermissionResponse> getAllPermissions() {
        return permissionRepository.findAll().stream()
                .map(permissionMapper::toPermissionResponse)
                .toList();
    }
}