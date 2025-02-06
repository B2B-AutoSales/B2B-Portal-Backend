package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.Organisation;
import b2b.autosales.portal.models.User;
import b2b.autosales.portal.dto.request.create.UserCreateRequest;
import b2b.autosales.portal.dto.request.update.UserUpdateRequest;
import b2b.autosales.portal.dto.response.UserResponse;
import b2b.autosales.portal.models.enums.RoleName;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RolePermissionMapper.class, OrganisationMapper.class})
public interface UserMapper {

    @Mapping(target = "role", source = "role")
    @Mapping(target = "organisation", source = "organisation")
    UserResponse toUserResponse(User user);

    User toUser(UserResponse userResponse);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "role", source = "role"),
            @Mapping(target = "organisation", source = "organisation")
    })
    User toUser(UserCreateRequest createUserRequest, RoleName role, Organisation organisation);

    @Mapping(target = "id", ignore = true)
    User toUser(UserUpdateRequest updateUserRequest);

    @Mapping(target = "id", ignore = true)
    void updateUserFromRequest(UserUpdateRequest updateUserRequest, @MappingTarget User user);
}