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
@Table(name = "orders")
@Tag(name = "Order", description = "Order Entity")
public class Order {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the order", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    @Schema(description = "Organisation associated with the order")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "User who placed the order")
    private User user;

    @Column(length = 50, nullable = false)
    @Schema(description = "Status of the order", example = "PROCESSING")
    private String status;

    @Column(name = "total_amount", nullable = false)
    @Schema(description = "Total amount of the order", example = "500.00")
    private Double totalAmount;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "Creation date of the order", example = "2023-01-01T12:00:00")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Schema(description = "Last update date of the order", example = "2023-01-01T12:00:00")
    private LocalDateTime updatedAt;
}