package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.RolePermissionCreateRequest;
import b2b.autosales.portal.dto.request.update.RolePermissionUpdateRequest;
import b2b.autosales.portal.dto.response.RolePermissionResponse;
import b2b.autosales.portal.service.RolePermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/role-permissions")
@Tag(name = "Role Permission Management", description = "APIs for managing role permissions")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new role permission", description = "Creates a new role permission with the provided details")
    @ApiResponse(responseCode = "201", description = "Role permission created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public RolePermissionResponse createRolePermission(@RequestBody @Valid RolePermissionCreateRequest createRequest) {
        return rolePermissionService.createRolePermission(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a role permission", description = "Updates an existing role permission with the provided details")
    @ApiResponse(responseCode = "200", description = "Role permission updated successfully")
    @ApiResponse(responseCode = "404", description = "Role permission not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public RolePermissionResponse updateRolePermission(
            @Parameter(description = "Role permission ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid RolePermissionUpdateRequest updateRequest) {
        return rolePermissionService.updateRolePermission(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a role permission", description = "Deletes a role permission by ID")
    @ApiResponse(responseCode = "204", description = "Role permission deleted successfully")
    @ApiResponse(responseCode = "404", description = "Role permission not found")
    public void deleteRolePermission(@Parameter(description = "Role permission ID", required = true) @PathVariable UUID id) {
        rolePermissionService.deleteRolePermission(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get role permission by ID", description = "Retrieves detailed role permission information")
    @ApiResponse(responseCode = "200", description = "Role permission found")
    @ApiResponse(responseCode = "404", description = "Role permission not found")
    public RolePermissionResponse getRolePermissionById(@Parameter(description = "Role permission ID", required = true) @PathVariable UUID id) {
        return rolePermissionService.getRolePermissionById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all role permissions", description = "Retrieves a list of all role permissions")
    @ApiResponse(responseCode = "200", description = "Role permissions retrieved successfully")
    public List<RolePermissionResponse> getAllRolePermissions() {
        return rolePermissionService.getAllRolePermissions();
    }
}