package b2b.autosales.portal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Notification Response DTO")
public record NotificationResponse(
        @Schema(description = "Id", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(description = "User", example = "User object")
        UserResponse user,

        @Schema(description = "Type", example = "ALERT")
        String type,

        @Schema(description = "Content", example = "New order received")
        String content,

        @Schema(description = "Is Read", example = "false")
        Boolean isRead,

        @Schema(description = "Created At", example = "2023-10-01T12:00:00")
        LocalDateTime createdAt
) {}