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
@Table(name = "cross_sale_recommendations")
@Schema(description = "Модель рекомендации перекрестной продажи")
public class CrossSaleRecommendation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор рекомендации")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  @Schema(description = "Основной товар")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "recommended_product_id", nullable = false)
  @Schema(description = "Рекомендуемый товар")
  private Product recommendedProduct;

  @Column(name = "confidence_score")
  @Schema(description = "Оценка уверенности в рекомендации")
  private Double confidenceScore;
}