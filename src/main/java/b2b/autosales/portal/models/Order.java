package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@Schema(description = "Модель заказа")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор заказа")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "organisation_id", nullable = false)
  @Schema(description = "Организация, разместившая заказ")
  private Organisation organisation;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @Schema(description = "Пользователь, создавший заказ")
  private User user;

  @Column(name = "status", nullable = false)
  @Schema(description = "Статус заказа")
  private String status;

  @Column(name = "total_amount", nullable = false)
  @Schema(description = "Общая сумма заказа")
  private Double totalAmount;

  @Column(name = "created_at", nullable = false)
  @Schema(description = "Дата и время создания заказа")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @Schema(description = "Дата и время последнего обновления заказа")
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "order")
  @Schema(description = "Позиции заказа")
  private Set<OrderItem> items;
}