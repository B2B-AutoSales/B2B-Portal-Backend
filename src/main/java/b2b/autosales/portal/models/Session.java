package b2b.autosales.portal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session")
public class Session {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(nullable = false, name = "request_ip")
    private String requestIp;

    @Column(nullable = false, name = "user_agent")
    private String userAgent;

    @Column(nullable = false, name = "refresh_token_expiry")
    private LocalDateTime refreshTokenExpiry;

    @Column(nullable = false, name = "is_blocked")
    private Boolean isBlocked;
}
