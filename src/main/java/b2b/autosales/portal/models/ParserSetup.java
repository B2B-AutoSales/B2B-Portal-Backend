package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "ParserSetup", description = "Parser Setup Entity")
public class ParserSetup {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the parser setup", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    @Schema(description = "Organisation associated with the parser setup")
    private Organisation organisation;

    @ElementCollection
    @Column(name = "key_words", nullable = false)
    @Schema(description = "List of key words for the parser", example = "[\"car\", \"auto\"]")
    private List<String> keyWords;

    @Column(columnDefinition = "JSONB", nullable = false)
    @Schema(description = "Filters for the parser", example = "{\"price\": {\"min\": 1000, \"max\": 5000}}")
    private String filters;
}