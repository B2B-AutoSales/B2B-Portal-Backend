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
@Table(name = "customer_interactions")
@Schema(description = "Модель взаимодействия с клиентом")
public class CustomerInteraction {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор взаимодействия")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  @Schema(description = "Клиент, с которым произошло взаимодействие")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @Schema(description = "Пользователь, осуществивший взаимодействие")
  private User user;

  @Column(name = "interaction_type", nullable = false)
  @Schema(description = "Тип взаимодействия")
  private String interactionType;

  @Column(name = "interaction_date", nullable = false)
  @Schema(description = "Дата и время взаимодействия")
  private LocalDateTime interactionDate;

  @Column(name = "notes", columnDefinition = "text")
  @Schema(description = "Примечания к взаимодействию")
  private String notes;
}