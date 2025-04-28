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
@Table(name = "commercial_proposals")
@Schema(description = "Модель коммерческого предложения")
public class CommercialProposal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор коммерческого предложения")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "organisation_id", nullable = false)
  @Schema(description = "Организация, предоставляющая коммерческое предложение")
  private Organisation organisation;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @Schema(description = "Пользователь, создавший коммерческое предложение")
  private User user;

  @ManyToOne
  @JoinColumn(name = "tender_id")
  @Schema(description = "Тендер, к которому относится коммерческое предложение")
  private Tender tender;

  @Column(name = "status", nullable = false)
  @Schema(description = "Статус коммерческого предложения")
  private String status;

  @Column(name = "total_amount", nullable = false)
  @Schema(description = "Общая сумма коммерческого предложения")
  private Double totalAmount;

  @Column(name = "created_at", nullable = false)
  @Schema(description = "Дата и время создания коммерческого предложения")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @Schema(description = "Дата и время последнего обновления коммерческого предложения")
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "commercialProposal")
  @Schema(description = "Позиции коммерческого предложения")
  private Set<CommercialProposalItem> items;
}