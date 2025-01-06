package b2b.autosales.portal.models;

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
public class CustomerInteraction {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "interaction_type", length = 50, nullable = false)
    private String interactionType;

    @Column(name = "interaction_date", nullable = false)
    private LocalDateTime interactionDate;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
