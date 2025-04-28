package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sessions")
@Schema(description = "Модель сессии пользователя")
public class Session {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор сессии")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @Schema(description = "Пользователь")
  private User user;

  @Column(name = "is_blocked")
  @Schema(description = "Признак блокировки сессии")
  private Boolean isBlocked;

  @Column(name = "request_ip")
  @Schema(description = "IP-адрес запроса")
  private String requestIp;

  @Column(name = "user_agent")
  @Schema(description = "User-Agent браузера")
  private String userAgent;

  @Column(name = "refresh_token_expiry")
  @Schema(description = "Время истечения refresh токена в секундах")
  private Integer refreshTokenExpiry;

  @Column(name = "created_at", nullable = false)
  @Schema(description = "Дата и время создания сессии")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @Schema(description = "Дата и время последнего обновления сессии")
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  @Schema(description = "Дата и время удаления сессии")
  private LocalDateTime deletedAt;
}