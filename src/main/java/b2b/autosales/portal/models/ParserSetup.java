package b2b.autosales.portal.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parser_setups")
public class ParserSetup {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    private Organisation organisation;

    @ElementCollection
    @Column(name = "key_words", nullable = false)
    private List<String> keyWords;

    @Column(columnDefinition = "JSONB", nullable = false)
    private String filters;
}
