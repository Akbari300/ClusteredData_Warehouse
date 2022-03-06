package org.carpool.car_mng;

import org.carpool.util.RevisionDto;
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
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Akbari300
 */
@RestController
@RequestMapping(path = "/api/car", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
    @Autowired
    private CarService carService;

    @Operation(summary = "Get all cars")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retrieve all cars", content = {
            @Content(schema = @Schema(implementation = Car.class)) }) })
    @GetMapping
    public List<Car> findAll() {
        return carService.findAll();
    }

    @Operation(summary = "Get an Car by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Car", content = {
                    @Content(schema = @Schema(implementation = Car.class)) }),
            @ApiResponse(responseCode = "404", description = "Car not found", content = @Content) })
    @GetMapping(path = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car findById(@PathVariable(name = "id", required = true) Long id) {
        return carService.findById(id);
    }

    @Operation(summary = "add a new car to the carpool, provide {deleted=false} ")
    @ApiResponse(responseCode = "200", description = "Car is added to the pool", content = {
            @Content(schema = @Schema(implementation = Car.class)) })
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Car> create(@RequestBody Car body, HttpServletRequest request)
            throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.create(body));
    }

    @Operation(summary = "Update a car by id, provide {deleted=false}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car was updated", content = {
                    @Content(schema = @Schema(implementation = Car.class)) }),
            @ApiResponse(responseCode = "404", description = "Car not found", content = @Content) })
    @PutMapping(path = "/updates/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Car> update(@PathVariable(name = "id", required = true) Long id,
            @RequestBody Car car, HttpServletRequest request) throws Exception {
        return ResponseEntity.ok(carService.update(id, car));
    }

    @Operation(summary = "Get RGBColor by id")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "retrieved RGB Color", content = {
            @Content(schema = @Schema(implementation = Car.class)) }) })
    @GetMapping(path = "/color/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Map<String, Object>> getRGBColor(
            @PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(carService.getColorRGB(id));
    }

    @Operation(summary = "delete a car by id")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(carService.delete(id));
    }

    @Operation(summary = "Retrive car audit logs by id")
    @ApiResponse(responseCode = "200", description = "car found", content = {
            @Content(schema = @Schema(implementation = RevisionDto.class)) })
    @GetMapping(path = "/audits/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RevisionDto>> getAccountAudits(@PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(carService.getCarAudits(id));

    }

}
