package b2b.autosales.portal.mapper;

import b2b.autosales.portal.models.Notification;
import b2b.autosales.portal.dto.request.create.NotificationCreateRequest;
import b2b.autosales.portal.dto.request.update.NotificationUpdateRequest;
import b2b.autosales.portal.dto.response.NotificationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface NotificationMapper {

    NotificationResponse toNotificationResponse(Notification notification);

    Notification toNotification(NotificationResponse notificationResponse);

    @Mapping(target = "id", ignore = true)
    Notification toNotification(NotificationCreateRequest createNotificationRequest);

    @Mapping(target = "id", ignore = true)
    Notification toNotification(NotificationUpdateRequest updateNotificationRequest);

    @Mapping(target = "id", ignore = true)
    void updateNotificationFromRequest(NotificationUpdateRequest updateNotificationRequest, @MappingTarget Notification notification);
}