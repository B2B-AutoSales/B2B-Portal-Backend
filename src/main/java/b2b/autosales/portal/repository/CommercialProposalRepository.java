package b2b.autosales.portal.repository;

import b2b.autosales.portal.models.CommercialProposal;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CommercialProposalRepository extends JpaRepository<CommercialProposal, UUID> {
}
