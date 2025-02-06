package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.NotificationCreateRequest;
import b2b.autosales.portal.dto.request.update.NotificationUpdateRequest;
import b2b.autosales.portal.dto.response.NotificationResponse;
import b2b.autosales.portal.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/notifications")
@Tag(name = "Notification Management", description = "APIs for managing notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new notification", description = "Creates a new notification with the provided details")
    @ApiResponse(responseCode = "201", description = "Notification created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public NotificationResponse createNotification(@RequestBody @Valid NotificationCreateRequest createRequest) {
        return notificationService.createNotification(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a notification", description = "Updates an existing notification with the provided details")
    @ApiResponse(responseCode = "200", description = "Notification updated successfully")
    @ApiResponse(responseCode = "404", description = "Notification not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public NotificationResponse updateNotification(
            @Parameter(description = "ID of the notification to update", required = true) @PathVariable UUID id,
            @RequestBody @Valid NotificationUpdateRequest updateRequest) {
        return notificationService.updateNotification(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a notification", description = "Deletes a notification by ID")
    @ApiResponse(responseCode = "204", description = "Notification deleted successfully")
    @ApiResponse(responseCode = "404", description = "Notification not found")
    public void deleteNotification(@Parameter(description = "ID of the notification to delete", required = true) @PathVariable UUID id) {
        notificationService.deleteNotification(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a notification by ID", description = "Retrieves a notification by its ID")
    @ApiResponse(responseCode = "200", description = "Notification found")
    @ApiResponse(responseCode = "404", description = "Notification not found")
    public NotificationResponse getNotificationById(@Parameter(description = "ID of the notification to retrieve", required = true) @PathVariable UUID id) {
        return notificationService.getNotificationById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all notifications", description = "Retrieves a list of all notifications")
    @ApiResponse(responseCode = "200", description = "List of notifications retrieved successfully")
    public List<NotificationResponse> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}