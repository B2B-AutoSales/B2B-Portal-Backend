package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.UserCreateRequest;
import b2b.autosales.portal.dto.request.update.UserUpdateRequest;
import b2b.autosales.portal.dto.response.UserResponse;
import b2b.autosales.portal.service.UserService;
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
@RequestMapping("api/v1/users")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {

    private final UserService userService;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a user", description = "Updates an existing user with the provided details")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public UserResponse updateUser(
            @Parameter(description = "ID of the user to update", required = true) @PathVariable UUID id,
            @RequestBody @Valid UserUpdateRequest updateRequest) {
        return userService.updateUser(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a user", description = "Deletes a user by ID")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @ApiResponse(responseCode = "404", description = "User not found")
    public void deleteUser(@Parameter(description = "ID of the user to delete", required = true) @PathVariable UUID id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a user by ID", description = "Retrieves a user by their ID")
    @ApiResponse(responseCode = "200", description = "User found")
    @ApiResponse(responseCode = "404", description = "User not found")
    public UserResponse getUserById(@Parameter(description = "ID of the user to retrieve", required = true) @PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all users", description = "Retrieves a list of all users")
    @ApiResponse(responseCode = "200", description = "List of users retrieved successfully")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}