package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Schema(description = "Модель пользователя")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор пользователя")
  private UUID id;

  @Column(name = "email", nullable = false, unique = true)
  @Schema(description = "Email пользователя")
  private String email;

  @Column(name = "password", nullable = false)
  @Schema(description = "Хэш пароля пользователя")
  private String password;

  @Column(name = "first_name", nullable = false)
  @Schema(description = "Имя пользователя")
  private String firstName;

  @Column(name = "last_name", nullable = false)
  @Schema(description = "Фамилия пользователя")
  private String lastName;

  @Column(name = "middle_name")
  @Schema(description = "Отчество пользователя")
  private String middleName;

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false)
  @Schema(description = "Роль пользователя")
  private Role role;

  @ManyToOne
  @JoinColumn(name = "organization_id", nullable = false)
  @Schema(description = "Организация пользователя")
  private Organisation organisation;

  @Column(name = "is_blocked")
  @Schema(description = "Признак блокировки пользователя")
  private Boolean isBlocked;

  @Column(name = "created_at", nullable = false)
  @Schema(description = "Дата и время создания учетной записи")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @Schema(description = "Дата и время последнего обновления учетной записи")
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  @Schema(description = "Дата и время удаления учетной записи")
  private LocalDateTime deletedAt;

  @OneToOne
  @JoinColumn(name = "registration_request_id")
  @Schema(description = "Заявка на регистрацию пользователя")
  private RegistrationRequest registrationRequest;

  @OneToMany(mappedBy = "user")
  @Schema(description = "Сессии пользователя")
  private Set<Session> sessions;

  @OneToMany(mappedBy = "user")
  @Schema(description = "Коммерческие предложения пользователя")
  private Set<CommercialProposal> commercialProposals;

  @OneToMany(mappedBy = "user")
  @Schema(description = "Заказы пользователя")
  private Set<Order> orders;

  @OneToMany(mappedBy = "user")
  @Schema(description = "Уведомления пользователя")
  private Set<Notification> notifications;

  @OneToMany(mappedBy = "user")
  @Schema(description = "Взаимодействия с клиентами")
  private Set<CustomerInteraction> customerInteractions;
}