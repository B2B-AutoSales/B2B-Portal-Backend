package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permissions")
@Schema(description = "Модель прав доступа")
public class Permission {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор права доступа")
  private UUID id;

  @Column(name = "name", nullable = false)
  @Schema(description = "Название права доступа")
  private String name;

  @ManyToMany(mappedBy = "permissions")
  @Schema(description = "Роли, имеющие данное право доступа")
  private Set<Role> roles;
}