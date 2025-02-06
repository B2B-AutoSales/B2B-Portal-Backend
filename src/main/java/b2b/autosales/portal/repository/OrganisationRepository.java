package b2b.autosales.portal.repository;

import b2b.autosales.portal.models.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, UUID> {
    boolean existsByName(String name);

    Optional<Organisation> findByName(String name);
}
