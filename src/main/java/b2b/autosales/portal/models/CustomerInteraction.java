package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_interactions")
@Tag(name = "CustomerInteraction", description = "Customer Interaction Entity")
public class CustomerInteraction {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the customer interaction", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @Schema(description = "Customer associated with the interaction")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "User who interacted with the customer")
    private User user;

    @Column(name = "interaction_type", length = 50, nullable = false)
    @Schema(description = "Type of interaction", example = "PHONE_CALL")
    private String interactionType;

    @Column(name = "interaction_date", nullable = false)
    @Schema(description = "Date and time of the interaction", example = "2023-01-01T12:00:00")
    private LocalDateTime interactionDate;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Notes about the interaction", example = "Discussed new product offerings")
    private String notes;
}