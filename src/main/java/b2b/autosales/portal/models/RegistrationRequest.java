package b2b.autosales.portal.models;

import b2b.autosales.portal.models.enums.RegistrationStatusName;
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
@Table(name = "registration_requests")
@Tag(name = "RegistrationRequest", description = "Registration Request Entity")
public class RegistrationRequest {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the registration request", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Column(nullable = false, length = 50, name = "firstname")
    @Schema(description = "First name of the requester", example = "John")
    private String firstname;

    @Column(nullable = false, length = 50, name = "lastname")
    @Schema(description = "Last name of the requester", example = "Doe")
    private String lastname;

    @Column(nullable = false, length = 50, name = "middlename")
    @Schema(description = "Middle name of the requester", example = "A.")
    private String middlename;

    @Column(nullable = false, length = 50, name = "country")
    @Schema(description = "Country of the requester", example = "USA")
    private String country;

    @Column(nullable = false, length = 50, name = "city")
    @Schema(description = "City of the requester", example = "New York")
    private String city;

    @Column(nullable = false, length = 50, name = "company_name")
    @Schema(description = "Company name of the requester", example = "ABC Corp")
    private String companyName;

    @Column(nullable = false, length = 50, name = "legal_adress")
    @Schema(description = "Legal address of the requester", example = "123 Main St")
    private String legalAdress;

    @Column(nullable = false, unique = true, length = 50, name = "email")
    @Schema(description = "Email of the requester", example = "john.doe@example.com")
    private String email;

    @Column(nullable = false, unique = true, length = 50, name = "login")
    @Schema(description = "Login of the requester", example = "johndoe")
    private String login;

    @Column(nullable = false, length = 100, name = "password")
    @Schema(description = "Password of the requester", example = "password123")
    private String password;

    @Column(nullable = false, length = 100, name = "phone_number")
    @Schema(description = "Phone number of the requester", example = "+1234567890")
    private String phoneNumber;

    @Column(nullable = false, length = 100, name = "position")
    @Schema(description = "Position of the requester", example = "Manager")
    private String position;

    @Column(nullable = false, length = 100, name = "inn")
    @Schema(description = "INN of the requester", example = "1234567890")
    private String inn;

    @Column(nullable = false, length = 100, name = "ceo_full_name")
    @Schema(description = "Full name of the CEO", example = "John Doe")
    private String ceoFullName;

    @Column(nullable = false, length = 200, name = "website")
    @Schema(description = "Website of the requester", example = "https://www.abccorp.com")
    private String website;

    @Column(nullable = false, length = 100, name = "activity_type")
    @Schema(description = "Type of activity of the requester", example = "Manufacturing")
    private String activityType;

    @Column(nullable = false, length = 100, name = "additional_info")
    @Schema(description = "Additional information about the requester", example = "Specializing in automotive parts")
    private String additionalInfo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100, name = "status")
    @Schema(description = "Status of the registration request", example = "PENDING")
    private RegistrationStatusName status;
}