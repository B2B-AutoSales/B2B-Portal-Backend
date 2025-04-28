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
@Table(name = "notifications")
@Schema(description = "Модель уведомления")
public class Notification {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор уведомления")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @Schema(description = "Пользователь, которому адресовано уведомление")
  private User user;

  @Column(name = "type", nullable = false)
  @Schema(description = "Тип уведомления")
  private String type;

  @Column(name = "content", columnDefinition = "text", nullable = false)
  @Schema(description = "Содержание уведомления")
  private String content;

  @Column(name = "is_read")
  @Schema(description = "Признак прочитанного уведомления")
  private Boolean isRead;

  @Column(name = "created_at", nullable = false)
  @Schema(description = "Дата и время создания уведомления")
  private LocalDateTime createdAt;
}