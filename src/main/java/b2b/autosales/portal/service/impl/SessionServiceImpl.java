package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.SessionCreateRequest;
import b2b.autosales.portal.dto.request.update.SessionUpdateRequest;
import b2b.autosales.portal.dto.response.SessionResponse;
import b2b.autosales.portal.mapper.SessionMapper;
import b2b.autosales.portal.models.Session;
import b2b.autosales.portal.repository.SessionRepository;
import b2b.autosales.portal.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    @Override
    public SessionResponse createSession(SessionCreateRequest createSessionRequest) {
        Session session = sessionMapper.toSession(createSessionRequest);
        return sessionMapper.toSessionResponse(sessionRepository.save(session));
    }

    @Override
    public SessionResponse updateSession(UUID id, SessionUpdateRequest updateSessionRequest) {
        Session existingSession = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        sessionMapper.updateSessionFromRequest(updateSessionRequest, existingSession);
        return sessionMapper.toSessionResponse(sessionRepository.save(existingSession));
    }

    @Override
    public void deleteSession(UUID id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public SessionResponse getSessionById(UUID id) {
        return sessionRepository.findById(id)
                .map(sessionMapper::toSessionResponse)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    @Override
    public List<SessionResponse> getAllSessions() {
        return sessionRepository.findAll().stream()
                .map(sessionMapper::toSessionResponse)
                .toList();
    }
}