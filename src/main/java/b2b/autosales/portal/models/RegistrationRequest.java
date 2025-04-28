package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration_requests")
@Schema(description = "Модель заявки на регистрацию")
public class RegistrationRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор заявки")
  private UUID id;

  @Column(name = "country")
  @Schema(description = "Страна")
  private String country;

  @Column(name = "company_name", nullable = false)
  @Schema(description = "Название компании")
  private String companyName;

  @Column(name = "city")
  @Schema(description = "Город")
  private String city;

  @Column(name = "legal_address")
  @Schema(description = "Юридический адрес")
  private String legalAddress;

  @Column(name = "login", nullable = false)
  @Schema(description = "Логин")
  private String login;

  @Column(name = "password", nullable = false)
  @Schema(description = "Пароль")
  private String password;

  @Column(name = "password_confirm", nullable = false)
  @Schema(description = "Подтверждение пароля")
  private String passwordConfirm;

  @Column(name = "phone_number")
  @Schema(description = "Номер телефона")
  private String phoneNumber;

  @Column(name = "email", nullable = false)
  @Schema(description = "Email")
  private String email;

  @Column(name = "first_name", nullable = false)
  @Schema(description = "Имя")
  private String firstName;

  @Column(name = "last_name", nullable = false)
  @Schema(description = "Фамилия")
  private String lastName;

  @Column(name = "middle_name")
  @Schema(description = "Отчество")
  private String middleName;

  @Column(name = "position")
  @Schema(description = "Должность")
  private String position;

  @Column(name = "inn")
  @Schema(description = "ИНН")
  private String inn;

  @Column(name = "ceo_full_name")
  @Schema(description = "ФИО генерального директора")
  private String ceoFullName;

  @Column(name = "website")
  @Schema(description = "Веб-сайт")
  private String website;

  @Column(name = "activity_type", columnDefinition = "varchar[]")
  @Schema(description = "Типы деятельности")
  private String[] activityType;

  @Column(name = "additional_info", columnDefinition = "text")
  @Schema(description = "Дополнительная информация")
  private String additionalInfo;

  @OneToOne(mappedBy = "registrationRequest")
  @Schema(description = "Пользователь, созданный по данной заявке")
  private User user;
}