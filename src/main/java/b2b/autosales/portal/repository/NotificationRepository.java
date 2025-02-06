package b2b.autosales.portal.repository;

import b2b.autosales.portal.models.Customer;
import b2b.autosales.portal.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}
