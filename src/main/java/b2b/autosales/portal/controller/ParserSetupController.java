package b2b.autosales.portal.controller;

import b2b.autosales.portal.dto.request.create.ParserSetupCreateRequest;
import b2b.autosales.portal.dto.request.update.ParserSetupUpdateRequest;
import b2b.autosales.portal.dto.response.ParserSetupResponse;
import b2b.autosales.portal.service.ParserSetupService;
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
@RequestMapping("api/v1/parser-setups")
@Tag(name = "Parser Setup Management", description = "APIs for managing parser setups")
public class ParserSetupController {

    private final ParserSetupService parserSetupService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new parser setup", description = "Creates a new parser setup with the provided details")
    @ApiResponse(responseCode = "201", description = "Parser setup created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    @ApiResponse(responseCode = "404", description = "Organisation not found")
    public ParserSetupResponse createParserSetup(
            @RequestBody @Valid ParserSetupCreateRequest createRequest) {
        return parserSetupService.createParserSetup(createRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a parser setup", description = "Updates an existing parser setup with the provided details")
    @ApiResponse(responseCode = "200", description = "Parser setup updated successfully")
    @ApiResponse(responseCode = "404", description = "Parser setup not found")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public ParserSetupResponse updateParserSetup(
            @Parameter(description = "Parser setup ID", required = true) @PathVariable UUID id,
            @RequestBody @Valid ParserSetupUpdateRequest updateRequest) {
        return parserSetupService.updateParserSetup(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a parser setup", description = "Deletes a parser setup by ID")
    @ApiResponse(responseCode = "204", description = "Parser setup deleted successfully")
    @ApiResponse(responseCode = "404", description = "Parser setup not found")
    public void deleteParserSetup(
            @Parameter(description = "Parser setup ID", required = true) @PathVariable UUID id) {
        parserSetupService.deleteParserSetup(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get parser setup by ID", description = "Retrieves detailed parser setup information")
    @ApiResponse(responseCode = "200", description = "Parser setup found")
    @ApiResponse(responseCode = "404", description = "Parser setup not found")
    public ParserSetupResponse getParserSetupById(
            @Parameter(description = "Parser setup ID", required = true) @PathVariable UUID id) {
        return parserSetupService.getParserSetupById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all parser setups", description = "Retrieves a list of all parser setups")
    @ApiResponse(responseCode = "200", description = "Parser setups retrieved successfully")
    public List<ParserSetupResponse> getAllParserSetups() {
        return parserSetupService.getAllParserSetups();
    }
}