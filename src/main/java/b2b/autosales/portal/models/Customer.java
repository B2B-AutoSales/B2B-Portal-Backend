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
@Table(name = "customers")
@Tag(name = "Customer", description = "Customer Entity")
public class Customer {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the customer", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    @Schema(description = "Organisation associated with the customer")
    private Organisation organisation;

    @Column(length = 100, nullable = false)
    @Schema(description = "Name of the customer", example = "John Doe")
    private String name;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Contact information of the customer", example = "john.doe@example.com")
    private String contactInfo;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Additional notes about the customer", example = "Preferred contact method: Email")
    private String notes;
}