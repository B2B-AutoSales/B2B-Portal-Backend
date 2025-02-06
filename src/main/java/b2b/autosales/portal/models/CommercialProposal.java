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
@Table(name = "commercial_proposals")
@Tag(name = "CommercialProposal", description = "Commercial Proposal Entity")
public class CommercialProposal {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the commercial proposal", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    @Schema(description = "Organisation associated with the commercial proposal")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "User who created the commercial proposal")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    @Schema(description = "Tender associated with the commercial proposal")
    private Tender tender;

    @Column(length = 50, nullable = false)
    @Schema(description = "Status of the commercial proposal", example = "DRAFT")
    private String status;

    @Column(name = "total_amount", nullable = false)
    @Schema(description = "Total amount of the commercial proposal", example = "1000.00")
    private Double totalAmount;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "Creation date of the commercial proposal", example = "2023-01-01T12:00:00")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Schema(description = "Last update date of the commercial proposal", example = "2023-01-01T12:00:00")
    private LocalDateTime updatedAt;
}