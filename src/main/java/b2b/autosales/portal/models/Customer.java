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
@Table(name = "customers")
@Schema(description = "Модель клиента")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор клиента")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "organisation_id", nullable = false)
  @Schema(description = "Организация, которой принадлежит клиент")
  private Organisation organisation;

  @Column(name = "name", nullable = false)
  @Schema(description = "Название/имя клиента")
  private String name;

  @Column(name = "contact_info", columnDefinition = "text")
  @Schema(description = "Контактная информация")
  private String contactInfo;

  @Column(name = "notes", columnDefinition = "text")
  @Schema(description = "Примечания")
  private String notes;

  @OneToMany(mappedBy = "customer")
  @Schema(description = "Взаимодействия с клиентом")
  private Set<CustomerInteraction> interactions;
}