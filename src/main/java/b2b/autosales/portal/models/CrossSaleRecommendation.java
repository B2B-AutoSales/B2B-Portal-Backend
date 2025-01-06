package b2b.autosales.portal.models;

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
@Table(name = "cross_sale_recommendations")
public class CrossSaleRecommendation {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "recommended_product_id", nullable = false)
    private Product recommendedProduct;

    @Column(name = "confidence_score", nullable = false)
    private Double confidenceScore;
}
