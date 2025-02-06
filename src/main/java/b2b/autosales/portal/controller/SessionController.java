package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.SessionCreateRequest;
import b2b.autosales.portal.dto.request.update.SessionUpdateRequest;
import b2b.autosales.portal.dto.response.SessionResponse;
import b2b.autosales.portal.service.SessionService;
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
@RequestMapping("api/v1/sessions")
@Tag(name = "Session Management", description = "APIs for managing user sessions")
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new session", description = "Creates a new user session")
    @ApiResponse(responseCode = "201", description = "Session created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    @ApiResponse(responseCode = "404", description = "User not found")
    public SessionResponse createSession(@RequestBody @Valid SessionCreateRequest createRequest) {
        return sessionService.createSession(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update session", description = "Updates existing session details")
    @ApiResponse(responseCode = "200", description = "Session updated successfully")
    @ApiResponse(responseCode = "404", description = "Session not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public SessionResponse updateSession(
            @Parameter(description = "Session ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid SessionUpdateRequest updateRequest) {
        return sessionService.updateSession(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete session", description = "Permanently removes a session")
    @ApiResponse(responseCode = "204", description = "Session deleted successfully")
    @ApiResponse(responseCode = "404", description = "Session not found")
    public void deleteSession(
            @Parameter(description = "Session ID", required = true) @PathVariable UUID id) {
        sessionService.deleteSession(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get session by ID", description = "Retrieves detailed session information")
    @ApiResponse(responseCode = "200", description = "Session found")
    @ApiResponse(responseCode = "404", description = "Session not found")
    public SessionResponse getSessionById(
            @Parameter(description = "Session ID", required = true) @PathVariable UUID id) {
        return sessionService.getSessionById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all sessions", description = "Retrieves list of all sessions")
    @ApiResponse(responseCode = "200", description = "Sessions retrieved successfully")
    public List<SessionResponse> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/active")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get active sessions", description = "Retrieves list of all active sessions")
    @ApiResponse(responseCode = "200", description = "Active sessions retrieved successfully")
    public List<SessionResponse> getActiveSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get sessions by user", description = "Retrieves all sessions for specific user")
    @ApiResponse(responseCode = "200", description = "Sessions retrieved successfully")
    @ApiResponse(responseCode = "404", description = "User not found")
    public SessionResponse getSessionsByUser(
            @Parameter(description = "User ID", required = true) @PathVariable UUID userId) {
        return sessionService.getSessionById(userId);
    }
}