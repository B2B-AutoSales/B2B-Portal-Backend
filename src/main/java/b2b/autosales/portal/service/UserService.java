package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.UserCreateRequest;
import b2b.autosales.portal.dto.request.update.UserUpdateRequest;
import b2b.autosales.portal.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

//    UserResponse createUser(UserCreateRequest createUserRequest);

    UserResponse updateUser(UUID id, UserUpdateRequest updateUserRequest);

    void deleteUser(UUID id);

    UserResponse getUserById(UUID id);

    List<UserResponse> getAllUsers();
}