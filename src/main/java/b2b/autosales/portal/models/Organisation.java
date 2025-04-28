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
@Table(name = "organisations")
@Schema(description = "Модель организации")
public class Organisation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор организации")
  private UUID id;

  @Column(name = "name", nullable = false)
  @Schema(description = "Название организации")
  private String name;

  @Column(name = "unp", nullable = false)
  @Schema(description = "УНП организации")
  private String unp;

  @Column(name = "is_customer")
  @Schema(description = "Признак того, что организация является покупателем")
  private Boolean isCustomer;

  @OneToMany(mappedBy = "organisation")
  @Schema(description = "Пользователи организации")
  private Set<User> users;

  @OneToMany(mappedBy = "organisation")
  @Schema(description = "Продукты организации")
  private Set<Product> products;

  @OneToOne(mappedBy = "organisation")
  @Schema(description = "Настройки парсера организации")
  private ParserSetup parserSetup;

  @OneToMany(mappedBy = "organisation")
  @Schema(description = "Коммерческие предложения организации")
  private Set<CommercialProposal> commercialProposals;

  @OneToMany(mappedBy = "organisation")
  @Schema(description = "Заказы организации")
  private Set<Order> orders;

  @OneToMany(mappedBy = "organisation")
  @Schema(description = "Клиенты организации")
  private Set<Customer> customers;
}