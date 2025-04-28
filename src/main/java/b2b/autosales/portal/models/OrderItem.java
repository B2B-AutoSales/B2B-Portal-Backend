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
@Table(name = "order_items")
@Schema(description = "Модель позиции заказа")
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор позиции заказа")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  @Schema(description = "Заказ, к которому относится позиция")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  @Schema(description = "Товар")
  private Product product;

  @Column(name = "quantity", nullable = false)
  @Schema(description = "Количество")
  private Integer quantity;

  @Column(name = "price", nullable = false)
  @Schema(description = "Цена товара в заказе")
  private Double price;
}