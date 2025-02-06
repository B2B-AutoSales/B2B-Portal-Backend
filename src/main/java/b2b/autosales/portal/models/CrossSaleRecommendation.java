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
@Table(name = "cross_sale_recommendations")
@Tag(name = "CrossSaleRecommendation", description = "Cross Sale Recommendation Entity")
public class CrossSaleRecommendation {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the cross sale recommendation", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @Schema(description = "Product associated with the recommendation")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "recommended_product_id", nullable = false)
    @Schema(description = "Recommended product")
    private Product recommendedProduct;

    @Column(name = "confidence_score", nullable = false)
    @Schema(description = "Confidence score of the recommendation", example = "0.85")
    private Double confidenceScore;
}