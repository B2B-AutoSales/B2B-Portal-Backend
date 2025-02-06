package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.RolePermissionCreateRequest;
import b2b.autosales.portal.dto.request.update.RolePermissionUpdateRequest;
import b2b.autosales.portal.dto.response.RolePermissionResponse;
import b2b.autosales.portal.mapper.RolePermissionMapper;
import b2b.autosales.portal.models.RolePermission;
import b2b.autosales.portal.repository.RolePermissionRepository;
import b2b.autosales.portal.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;
    private final RolePermissionMapper rolePermissionMapper;

    @Override
    public RolePermissionResponse createRolePermission(RolePermissionCreateRequest createRolePermissionRequest) {
        RolePermission rolePermission = rolePermissionMapper.toRolePermission(createRolePermissionRequest);
        return rolePermissionMapper.toRolePermissionResponse(rolePermissionRepository.save(rolePermission));
    }

    @Override
    public RolePermissionResponse updateRolePermission(UUID id, RolePermissionUpdateRequest updateRolePermissionRequest) {
        RolePermission existingRolePermission = rolePermissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolePermission not found"));

        rolePermissionMapper.updateRolePermissionFromRequest(updateRolePermissionRequest, existingRolePermission);
        return rolePermissionMapper.toRolePermissionResponse(rolePermissionRepository.save(existingRolePermission));
    }

    @Override
    public void deleteRolePermission(UUID id) {
        rolePermissionRepository.deleteById(id);
    }

    @Override
    public RolePermissionResponse getRolePermissionById(UUID id) {
        return rolePermissionRepository.findById(id)
                .map(rolePermissionMapper::toRolePermissionResponse)
                .orElseThrow(() -> new RuntimeException("RolePermission not found"));
    }

    @Override
    public List<RolePermissionResponse> getAllRolePermissions() {
        return rolePermissionRepository.findAll().stream()
                .map(rolePermissionMapper::toRolePermissionResponse)
                .toList();
    }
}