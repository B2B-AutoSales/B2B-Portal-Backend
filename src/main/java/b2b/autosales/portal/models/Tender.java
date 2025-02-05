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
@Table(name = "tenders")
@Tag(name = "Tender", description = "Tender Entity")
public class Tender {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the tender", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Column(length = 100, nullable = false)
    @Schema(description = "Source of the tender", example = "Government")
    private String source;

    @Column(length = 200, nullable = false)
    @Schema(description = "Title of the tender", example = "Supply of Vehicles")
    private String title;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Description of the tender", example = "Supply of 100 vehicles for government use")
    private String description;

    @Column(name = "published_date", nullable = false)
    @Schema(description = "Publication date of the tender", example = "2023-01-01T12:00:00")
    private LocalDateTime publishedDate;

    @Column(name = "closing_date", nullable = false)
    @Schema(description = "Closing date of the tender", example = "2023-01-31T12:00:00")
    private LocalDateTime closingDate;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    @Schema(description = "Organisation associated with the tender")
    private Organisation organisation;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "Creation date of the tender", example = "2023-01-01T12:00:00")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Schema(description = "Last update date of the tender", example = "2023-01-01T12:00:00")
    private LocalDateTime updatedAt;
}