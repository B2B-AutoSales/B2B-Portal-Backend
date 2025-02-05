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
@Table(name = "products")
@Tag(name = "Product", description = "Product Entity")
public class Product {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the product", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Column(length = 100, nullable = false)
    @Schema(description = "Name of the product", example = "Car Model X")
    private String name;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Description of the product", example = "A high-performance car with advanced features")
    private String description;

    @Column(nullable = false)
    @Schema(description = "Price of the product", example = "50000.00")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    @Schema(description = "Organisation associated with the product")
    private Organisation organisation;

    @Column(name = "object_id", nullable = false)
    @Schema(description = "Object identifier of the product", example = "12345")
    private UUID objectId;
}