package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Session Response DTO")
public record SessionResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "User", example = "User object")
        UserResponse user,

        @Schema(description = "Created At", example = "2023-10-01T12:00:00")
        LocalDateTime createdAt,

        @Schema(description = "Updated At", example = "2023-10-01T12:00:00")
        LocalDateTime updatedAt,

        @Schema(description = "Deleted At", example = "2023-10-01T12:00:00")
        LocalDateTime deletedAt,

        @Schema(description = "Request IP", example = "192.168.1.1")
        String requestIp,

        @Schema(description = "User Agent", example = "Mozilla/5.0")
        String userAgent,

        @Schema(description = "Refresh Token Expiry", example = "2023-10-01T12:00:00")
        LocalDateTime refreshTokenExpiry,

        @Schema(description = "Is Blocked", example = "false")
        Boolean isBlocked
) {}