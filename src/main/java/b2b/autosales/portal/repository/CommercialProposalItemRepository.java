package b2b.autosales.portal.repository;

import b2b.autosales.portal.models.CommercialProposalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CommercialProposalItemRepository extends JpaRepository<CommercialProposalItem, UUID> {
}
