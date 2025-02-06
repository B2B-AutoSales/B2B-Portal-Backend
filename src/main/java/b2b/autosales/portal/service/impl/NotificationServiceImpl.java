package b2b.autosales.portal.service.impl;

import b2b.autosales.portal.dto.request.create.NotificationCreateRequest;
import b2b.autosales.portal.dto.request.update.NotificationUpdateRequest;
import b2b.autosales.portal.dto.response.NotificationResponse;
import b2b.autosales.portal.mapper.NotificationMapper;
import b2b.autosales.portal.models.Notification;
import b2b.autosales.portal.repository.NotificationRepository;
import b2b.autosales.portal.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public NotificationResponse createNotification(NotificationCreateRequest createNotificationRequest) {
        Notification notification = notificationMapper.toNotification(createNotificationRequest);
        return notificationMapper.toNotificationResponse(notificationRepository.save(notification));
    }

    @Override
    public NotificationResponse updateNotification(UUID id, NotificationUpdateRequest updateNotificationRequest) {
        Notification existingNotification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notificationMapper.updateNotificationFromRequest(updateNotificationRequest, existingNotification);
        return notificationMapper.toNotificationResponse(notificationRepository.save(existingNotification));
    }

    @Override
    public void deleteNotification(UUID id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public NotificationResponse getNotificationById(UUID id) {
        return notificationRepository.findById(id)
                .map(notificationMapper::toNotificationResponse)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    @Override
    public List<NotificationResponse> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(notificationMapper::toNotificationResponse)
                .toList();
    }
}