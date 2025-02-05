package b2b.autosales.portal.models;

import b2b.autosales.portal.models.enums.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Tag(name = "User", description = "User Entity")
public class User {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Schema(description = "Unique identifier of the user", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Column(length = 50)
    @Schema(description = "First name of the user", example = "John")
    private String firstname;

    @Column(length = 50)
    @Schema(description = "Last name of the user", example = "Doe")
    private String lastname;

    @Column(length = 50)
    @Schema(description = "Middle name of the user", example = "A.")
    private String middlename;

    @Column(unique = true, length = 50)
    @Schema(description = "Email of the user", example = "john.doe@example.com")
    private String email;

    @Column(length = 100)
    @Schema(description = "Password of the user", example = "password123")
    private String password;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    @Schema(description = "Organisation associated with the user")
    private Organisation organisation;

    @Column(name = "created_at")
    @Schema(description = "Creation date of the user", example = "2023-01-01")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    @Schema(description = "Last update date of the user", example = "2023-01-01")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    @Schema(description = "Deletion date of the user", example = "2023-01-01")
    private LocalDate deletedAt;

    @Column(length = 10, name = "is_blocked")
    @Schema(description = "Indicates if the user is blocked", example = "false")
    private Boolean isBlocked;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, name = "role")
    @Schema(description = "Role of the user", example = "ADMIN")
    private RoleName role;

    @OneToOne
    @JoinColumn(name = "registration_request_id")
    @Schema(description = "Registration request associated with the user")
    private RegistrationRequest registration_requests;

    @OneToMany(mappedBy = "user")
    @Schema(description = "List of sessions associated with the user")
    private List<Session> sessions;
}