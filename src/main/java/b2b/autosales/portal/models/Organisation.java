package b2b.autosales.portal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Entity
@Getter
@Setter
@Table(name = "organisation")
public class Organisation {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Column(nullable = false, unique = true, name = "unp")
    private String unp;

    @Column(nullable = false, name = "is_customer")
    private Boolean isCustomer;

    public Organisation(String name, String unp, Boolean isCustomer) {
        this.name = name;
        this.unp = unp;
        this.isCustomer = isCustomer;
    }
}
