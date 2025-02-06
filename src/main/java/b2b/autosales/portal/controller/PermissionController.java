package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.PermissionCreateRequest;
import b2b.autosales.portal.dto.request.update.PermissionUpdateRequest;
import b2b.autosales.portal.dto.response.PermissionResponse;
import b2b.autosales.portal.service.PermissionService;
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
@RequestMapping("api/v1/permissions")
@Tag(name = "Permission Management", description = "APIs for managing permissions")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new permission", description = "Creates a new permission with the provided details")
    @ApiResponse(responseCode = "201", description = "Permission created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public PermissionResponse createPermission(@RequestBody @Valid PermissionCreateRequest createRequest) {
        return permissionService.createPermission(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a permission", description = "Updates an existing permission with the provided details")
    @ApiResponse(responseCode = "200", description = "Permission updated successfully")
    @ApiResponse(responseCode = "404", description = "Permission not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public PermissionResponse updatePermission(
            @Parameter(description = "Permission ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid PermissionUpdateRequest updateRequest) {
        return permissionService.updatePermission(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a permission", description = "Deletes a permission by ID")
    @ApiResponse(responseCode = "204", description = "Permission deleted successfully")
    @ApiResponse(responseCode = "404", description = "Permission not found")
    public void deletePermission(@Parameter(description = "Permission ID", required = true) @PathVariable UUID id) {
        permissionService.deletePermission(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get permission by ID", description = "Retrieves detailed permission information")
    @ApiResponse(responseCode = "200", description = "Permission found")
    @ApiResponse(responseCode = "404", description = "Permission not found")
    public PermissionResponse getPermissionById(@Parameter(description = "Permission ID", required = true) @PathVariable UUID id) {
        return permissionService.getPermissionById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all permissions", description = "Retrieves a list of all permissions")
    @ApiResponse(responseCode = "200", description = "Permissions retrieved successfully")
    public List<PermissionResponse> getAllPermissions() {
        return permissionService.getAllPermissions();
    }
}