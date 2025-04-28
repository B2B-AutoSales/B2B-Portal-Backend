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
@Table(name = "tenders")
@Schema(description = "Модель тендера")
public class Tender {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор тендера")
  private UUID id;

  @Column(name = "source")
  @Schema(description = "Источник информации о тендере")
  private String source;

  @Column(name = "title", nullable = false)
  @Schema(description = "Заголовок тендера")
  private String title;

  @Column(name = "description", columnDefinition = "text")
  @Schema(description = "Описание тендера")
  private String description;

  @Column(name = "published_date")
  @Schema(description = "Дата публикации тендера")
  private LocalDateTime publishedDate;

  @Column(name = "closing_date")
  @Schema(description = "Дата закрытия тендера")
  private LocalDateTime closingDate;

  @ManyToOne
  @JoinColumn(name = "organization_id")
  @Schema(description = "Организация, разместившая тендер")
  private Organisation organisation;

  @Column(name = "created_at", nullable = false)
  @Schema(description = "Дата и время создания записи о тендере")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @Schema(description = "Дата и время последнего обновления записи о тендере")
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "tender")
  @Schema(description = "Коммерческие предложения по тендеру")
  private Set<CommercialProposal> commercialProposals;
}