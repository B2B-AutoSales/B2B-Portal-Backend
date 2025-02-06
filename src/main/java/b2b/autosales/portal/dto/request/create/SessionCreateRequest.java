package b2b.autosales.portal.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Session Create Request DTO")
public record SessionCreateRequest(
        @Schema(description = "User ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID userId,

        @Schema(description = "Request IP", example = "192.168.1.1")
        String requestIp,

        @Schema(description = "User Agent", example = "Mozilla/5.0")
        String userAgent,

        @Schema(description = "Refresh Token Expiry", example = "2023-10-01T12:00:00")
        LocalDateTime refreshTokenExpiry
) {}