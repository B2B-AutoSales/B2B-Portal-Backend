package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session")
@Tag(name = "Session", description = "Session Entity")
public class Session {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the session", example = "550e8400-e29b-41d4-a716-446655440000")
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Schema(description = "User associated with the session")
    public User user;

    @Column(nullable = false, name = "created_at")
    @Schema(description = "Creation date of the session", example = "2023-01-01T12:00:00")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    @Schema(description = "Last update date of the session", example = "2023-01-01T12:00:00")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    @Schema(description = "Deletion date of the session", example = "2023-01-01T12:00:00")
    private LocalDateTime deletedAt;

    @Column(nullable = false, name = "request_ip")
    @Schema(description = "IP address of the request", example = "192.168.1.1")
    private String requestIp;

    @Column(nullable = false, name = "user_agent")
    @Schema(description = "User agent of the request", example = "Mozilla/5.0")
    private String userAgent;

    @Column(nullable = false, name = "refresh_token_expiry")
    @Schema(description = "Expiry date of the refresh token", example = "2023-01-01T12:00:00")
    private LocalDateTime refreshTokenExpiry;

    @Column(nullable = false, name = "is_blocked")
    @Schema(description = "Indicates if the session is blocked", example = "false")
    private Boolean isBlocked;
}