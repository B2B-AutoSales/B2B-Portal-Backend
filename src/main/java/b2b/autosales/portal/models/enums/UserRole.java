package b2b.autosales.portal.models.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Перечисление ролей пользователей")
public enum UserRole {
  @Schema(description = "Администратор системы")
  ADMIN("Админ"),

  @Schema(description = "Покупатель")
  CUSTOMER("Покупатель"),

  @Schema(description = "Продавец")
  SELLER("Продавец");

  private final String displayName;

  UserRole(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}