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
@Table(name = "permissions")
@Tag(name = "Permission", description = "Permission Entity")
public class Permission {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the permission", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Column(length = 100, nullable = false)
    @Schema(description = "Name of the permission", example = "READ")
    private String name;
}