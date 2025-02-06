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
@Table(name = "commercial_proposal_items")
@Tag(name = "CommercialProposalItem", description = "Commercial Proposal Item Entity")
public class CommercialProposalItem {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the commercial proposal item", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "commercial_proposal_id", nullable = false)
    @Schema(description = "Commercial proposal associated with the item")
    private CommercialProposal commercialProposal;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @Schema(description = "Product associated with the item")
    private Product product;

    @Column(nullable = false)
    @Schema(description = "Quantity of the product in the item", example = "5")
    private Integer quantity;

    @Column(nullable = false)
    @Schema(description = "Price of the product in the item", example = "100.00")
    private Double price;
}