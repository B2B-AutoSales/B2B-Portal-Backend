package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.UserCreateRequest;
import b2b.autosales.portal.dto.request.update.UserUpdateRequest;
import b2b.autosales.portal.dto.response.UserResponse;
import b2b.autosales.portal.mapper.UserMapper;
import b2b.autosales.portal.models.Organisation;
import b2b.autosales.portal.models.User;
import b2b.autosales.portal.repository.OrganisationRepository;
import b2b.autosales.portal.repository.RolePermissionRepository;
import b2b.autosales.portal.repository.UserRepository;
import b2b.autosales.portal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final OrganisationRepository organisationRepository;
    private final RolePermissionRepository roleRepository;


    @Override
    public UserResponse updateUser(UUID id, UserUpdateRequest updateUserRequest) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUserFromRequest(updateUserRequest, existingUser);
        return userMapper.toUserResponse(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse getUserById(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::toUserResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }
}