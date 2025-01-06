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
@Table(name = "tenders")
public class Tender {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String source;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "published_date", nullable = false)
    private LocalDateTime publishedDate;

    @Column(name = "closing_date", nullable = false)
    private LocalDateTime closingDate;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organisation organisation;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
