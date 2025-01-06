package b2b.autosales.portal.models;
import b2b.autosales.portal.models.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import javax.management.relation.Role;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_permissions")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(  length = 10, name = "role")
    private RoleName role;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;
}
