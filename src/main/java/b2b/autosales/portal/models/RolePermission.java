package b2b.autosales.portal.models;

import b2b.autosales.portal.models.enums.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_permissions")
@Tag(name = "RolePermission", description = "Role Permission Entity")
public class RolePermission {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the parser setup", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, name = "role")
    @Schema(description = "Role associated with the permission", example = "ADMIN")
    private RoleName role;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    @Schema(description = "Permission associated with the role")
    private Permission permission;
}