package b2b.autosales.portal.models;

import b2b.autosales.portal.models.enums.RoleName;
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
@Table(name = "role_permissions")
@Tag(name = "RolePermission", description = "Role Permission Entity")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the role permission", example = "1")
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