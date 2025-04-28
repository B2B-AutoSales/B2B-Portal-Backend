package b2b.autosales.portal.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parser_setups")
@Schema(description = "Модель настроек парсера")
public class ParserSetup {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @Schema(description = "Уникальный идентификатор настроек парсера")
  private UUID id;

  @OneToOne
  @JoinColumn(name = "organization_id", nullable = false)
  @Schema(description = "Организация, для которой настроен парсер")
  private Organisation organisation;

  @Column(name = "key_words", columnDefinition = "varchar[]")
  @Schema(description = "Ключевые слова для поиска")
  private String[] keyWords;

  @Column(name = "filters", columnDefinition = "jsonb")
  @Schema(description = "Фильтры для поиска в формате JSON")
  private String filters;
}