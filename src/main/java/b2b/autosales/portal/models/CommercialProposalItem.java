package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commercial_proposal_items")
@Schema(description = "Модель позиции коммерческого предложения")
public class CommercialProposalItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор позиции коммерческого предложения")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "commercial_proposal_id", nullable = false)
  @Schema(description = "Коммерческое предложение, к которому относится позиция")
  private CommercialProposal commercialProposal;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  @Schema(description = "Товар")
  private Product product;

  @Column(name = "quantity", nullable = false)
  @Schema(description = "Количество")
  private Integer quantity;

  @Column(name = "price", nullable = false)
  @Schema(description = "Цена товара в коммерческом предложении")
  private Double price;
}