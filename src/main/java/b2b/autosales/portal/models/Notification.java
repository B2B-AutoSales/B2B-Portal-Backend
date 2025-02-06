package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifications")
@Tag(name = "Notification", description = "Notification Entity")
public class Notification {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the notification", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "User who received the notification")
    private User user;

    @Column(length = 50, nullable = false)
    @Schema(description = "Type of the notification", example = "ALERT")
    private String type;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Content of the notification", example = "Your order has been shipped")
    private String content;

    @Column(name = "is_read", nullable = false)
    @Schema(description = "Indicates if the notification has been read", example = "false")
    private Boolean isRead;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "Creation date of the notification", example = "2023-01-01T12:00:00")
    private LocalDateTime createdAt;
}