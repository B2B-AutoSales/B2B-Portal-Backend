package b2b.autosales.portal.models;

import b2b.autosales.portal.models.enums.RoleName;
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
public class User {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @Column(length = 50)
    private String middlename;

    @Column(unique = true, length = 50)
    private String email;

    @Column(length = 100)
    private String password;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    private Organisation organisation;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(  name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @Column(  length = 10, name = "is_blocked")
    private Boolean isBlocked;

    @Enumerated(EnumType.STRING)
    @Column(  length = 10, name = "role")
    private RoleName role;

    @OneToOne
    @JoinColumn(name = "registration_request_id")
    private RegistrationRequest registration_requests;

    @OneToMany(mappedBy = "user")
    private List<Session> sessions;

}
