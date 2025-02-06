package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
@Tag(name = "OrderItem", description = "Order Item Entity")
public class OrderItem {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the order item", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @Schema(description = "Order associated with the item")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @Schema(description = "Product associated with the item")
    private Product product;

    @Column(nullable = false)
    @Schema(description = "Quantity of the product in the item", example = "2")
    private Integer quantity;

    @Column(nullable = false)
    @Schema(description = "Price of the product in the item", example = "50.00")
    private Double price;
}