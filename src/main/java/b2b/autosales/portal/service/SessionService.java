package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.SessionCreateRequest;
import b2b.autosales.portal.dto.request.update.SessionUpdateRequest;
import b2b.autosales.portal.dto.response.SessionResponse;

import java.util.List;
import java.util.UUID;

public interface SessionService {

    SessionResponse createSession(SessionCreateRequest createSessionRequest);

    SessionResponse updateSession(UUID id, SessionUpdateRequest updateSessionRequest);

    void deleteSession(UUID id);

    SessionResponse getSessionById(UUID id);

    List<SessionResponse> getAllSessions();
}