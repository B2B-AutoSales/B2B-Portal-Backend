package b2b.autosales.portal.models;

import b2b.autosales.portal.models.enums.RegistrationStatusName;
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
@Table(name = "registration_requests")
public class RegistrationRequest {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(nullable = false, length = 50, name = "firstname")
    private String firstname;

    @Column(nullable = false, length = 50, name = "lastname")
    private String lastname;

    @Column(nullable = false, length = 50, name = "middlename")
    private String middlename;

    @Column(nullable = false, length = 50, name = "country")
    private String country;

    @Column(nullable = false, length = 50, name = "city")
    private String city;

    @Column(nullable = false, length = 50, name = "company_name")
    private String companyName;

    @Column(nullable = false, length = 50, name = "legal_adress")
    private String legalAdress;

    @Column(nullable = false, unique = true, length = 50, name = "email")
    private String email;

    @Column(nullable = false, unique = true, length = 50, name = "login")
    private String login;

    @Column(nullable = false, length = 100, name = "password")
    private String password;

    @Column(nullable = false, length = 100, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, length = 100, name = "position")
    private String position;

    @Column(nullable = false, length = 100, name = "inn")
    private String inn;

    @Column(nullable = false, length = 100, name = "ceo_full_name")
    private String ceoFullName;

    @Column(nullable = false, length = 200, name = "website")
    private String website;

    @Column(nullable = false, length = 100, name = "activity_type")
    private String activityType;

    @Column(nullable = false, length = 100, name = "additional_info")
    private String additionalInfo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100, name = "status")
    private RegistrationStatusName status;
}
