package b2b.autosales.portal.mapper;

import b2b.autosales.portal.dto.request.create.SessionCreateRequest;
import b2b.autosales.portal.dto.request.update.SessionUpdateRequest;
import b2b.autosales.portal.dto.response.SessionResponse;
import b2b.autosales.portal.models.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface SessionMapper {

    SessionResponse toSessionResponse(Session session);

    Session toSession(SessionResponse sessionResponse);

    @Mapping(target = "id", ignore = true)
    Session toSession(SessionCreateRequest createSessionRequest);

    @Mapping(target = "id", ignore = true)
    Session toSession(SessionUpdateRequest updateSessionRequest);

    @Mapping(target = "id", ignore = true)
    void updateSessionFromRequest(SessionUpdateRequest updateSessionRequest, @MappingTarget Session session);
}