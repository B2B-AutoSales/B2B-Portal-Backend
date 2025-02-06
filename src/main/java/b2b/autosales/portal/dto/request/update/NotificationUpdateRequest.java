package b2b.autosales.portal.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Notification Update Request DTO")
public record NotificationUpdateRequest(
        @Schema(description = "Is Read", example = "true")
        Boolean isRead
) {}