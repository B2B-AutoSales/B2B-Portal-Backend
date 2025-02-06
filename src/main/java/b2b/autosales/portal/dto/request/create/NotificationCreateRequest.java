package b2b.autosales.portal.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Notification Create Request DTO")
public record NotificationCreateRequest(
        @Schema(description = "User ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID userId,

        @Schema(description = "Type", example = "ALERT")
        String type,

        @Schema(description = "Content", example = "New order received")
        String content,

        @Schema(description = "Is Read", example = "false")
        Boolean isRead
) {}