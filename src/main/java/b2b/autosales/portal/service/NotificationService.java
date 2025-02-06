package b2b.autosales.portal.service;

import b2b.autosales.portal.dto.request.create.NotificationCreateRequest;
import b2b.autosales.portal.dto.request.update.NotificationUpdateRequest;
import b2b.autosales.portal.dto.response.NotificationResponse;

import java.util.List;
import java.util.UUID;

public interface NotificationService {

    NotificationResponse createNotification(NotificationCreateRequest createNotificationRequest);

    NotificationResponse updateNotification(UUID id, NotificationUpdateRequest updateNotificationRequest);

    void deleteNotification(UUID id);

    NotificationResponse getNotificationById(UUID id);

    List<NotificationResponse> getAllNotifications();
}