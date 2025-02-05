package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Entity
@Getter
@Setter
@Table(name = "organisation")
@Tag(name = "Organisation", description = "Organisation Entity")
public class Organisation {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the organisation", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Column(nullable = false, unique = true, name = "name")
    @Schema(description = "Name of the organisation", example = "ABC Corp")
    private String name;

    @Column(nullable = false, unique = true, name = "unp")
    @Schema(description = "UNP (Unique Number of the Organisation)", example = "123456789")
    private String unp;

    @Column(nullable = false, name = "is_customer")
    @Schema(description = "Indicates if the organisation is a customer", example = "true")
    private Boolean isCustomer;
}