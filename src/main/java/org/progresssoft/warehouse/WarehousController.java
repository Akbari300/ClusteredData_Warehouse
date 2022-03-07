package org.progresssoft.warehouse;

import org.progresssoft.util.RevisionDto;
import org.progresssoft.warehouse.dto.WarehouseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Akbari300
 */
@RestController
@RequestMapping(path = "/api/v1/warehouse", produces = MediaType.APPLICATION_JSON_VALUE)
public class WarehousController {
    @Autowired
    private WarehouseService warehouseService;

    @Operation(summary = "Get all deals")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retrieve all deals", content = {
            @Content(schema = @Schema(implementation = Warehouse.class)) }) })
    @GetMapping
    public List<Warehouse> findAll() {
        return warehouseService.findAll();
    }

    @Operation(summary = "Get a deal by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the deal in warehouse", content = {
                    @Content(schema = @Schema(implementation = Warehouse.class)) }),
            @ApiResponse(responseCode = "404", description = "deal not found", content = @Content) })
    @GetMapping(path = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public Warehouse findById(@PathVariable(name = "id", required = true) Long id) {
        return warehouseService.findById(id);
    }

    @Operation(summary = "add a new deal to the warehouse")
    @ApiResponse(responseCode = "200", description = "Deal is added to the warehouse", content = {
            @Content(schema = @Schema(implementation = WarehouseDto.class)) })
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> create(@RequestBody WarehouseDto body, HttpServletRequest request)
            throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseService.create(body));
    }

    @Operation(summary = "Update a deal by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deal is updated", content = {
                    @Content(schema = @Schema(implementation = WarehouseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Deal not found", content = @Content) })
    @PutMapping(path = "/updates/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Warehouse> update(@PathVariable(name = "id", required = true) Long id,
            @RequestBody WarehouseDto car, HttpServletRequest request) throws Exception {
        return ResponseEntity.ok(warehouseService.update(id, car));
    }

    @Operation(summary = "delete a Deal by id")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(warehouseService.delete(id));
    }

    @Operation(summary = "Retrive Deal audit logs by id")
    @ApiResponse(responseCode = "200", description = "Deal found", content = {
            @Content(schema = @Schema(implementation = RevisionDto.class)) })
    @GetMapping(path = "/audits/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RevisionDto>> getDealsAudits(@PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(warehouseService.getWareHouseAudits(id));

    }

}
