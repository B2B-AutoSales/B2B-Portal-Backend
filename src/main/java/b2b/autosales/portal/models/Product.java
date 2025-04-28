package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@Schema(description = "Модель товара")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор товара")
  private UUID id;

  @Column(name = "name", nullable = false)
  @Schema(description = "Название товара")
  private String name;

  @Column(name = "description", columnDefinition = "text")
  @Schema(description = "Описание товара")
  private String description;

  @Column(name = "price", nullable = false)
  @Schema(description = "Цена товара")
  private Double price;

  @ManyToOne
  @JoinColumn(name = "organisation_id", nullable = false)
  @Schema(description = "Организация, предлагающая товар")
  private Organisation organisation;

  @Column(name = "object_id")
  @Schema(description = "Идентификатор объекта, связанного с товаром")
  private UUID objectId;

  @OneToMany(mappedBy = "product")
  @Schema(description = "Позиции в коммерческих предложениях")
  private Set<CommercialProposalItem> commercialProposalItems;

  @OneToMany(mappedBy = "product")
  @Schema(description = "Позиции в заказах")
  private Set<OrderItem> orderItems;

  @OneToMany(mappedBy = "product")
  @Schema(description = "Рекомендации по перекрестным продажам, где этот товар является основным")
  private Set<CrossSaleRecommendation> crossSaleRecommendations;

  @OneToMany(mappedBy = "recommendedProduct")
  @Schema(description = "Рекомендации по перекрестным продажам, где этот товар рекомендуется")
  private Set<CrossSaleRecommendation> recommendedInCrossSales;
}