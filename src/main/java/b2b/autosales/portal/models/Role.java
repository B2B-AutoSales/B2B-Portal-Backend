package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

import b2b.autosales.portal.models.enums.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@Schema(description = "Модель роли пользователя")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор роли")
  private UUID id;

  @Column(name = "name", nullable = false)
  @Schema(description = "Название роли")
  private UserRole role;

  @OneToMany(mappedBy = "role")
  @Schema(description = "Пользователи с данной ролью")
  private Set<User> users;

  @ManyToMany
  @JoinTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
  @Schema(description = "Права доступа, связанные с ролью")
  private Set<Permission> permissions;
}