package org.progresssoft.warehouse.impl;

import org.progresssoft.util.RevisionDto;
import org.progresssoft.warehouse.Warehouse;
import org.progresssoft.warehouse.WareRepository;
import org.progresssoft.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Akbari300
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WareRepository repository;

    // retrieve all cars
    @Override
    public List<Warehouse> findAll() {
        return repository.findAll();
    }

    // retrieve car by id
    @Override
    public Warehouse findById(Long id) {
        // Optional<Warehouse> car = repository.findById(id);
        // if (car.isPresent())
        //     return car.get();
        return null;
    }

    // create new car
    @Override
    public Warehouse create(Warehouse car) {
        // if (car != null) {
        //     return repository.save(car);
        // }
        return null;
    }

    // update an existing car info
    @Override
    public Warehouse update(Long id, Warehouse dto) {
        // Warehouse car = this.findById(id);
        // if (car != null) {
        //     return repository.save(this.carMapper(car, dto));
        // }
        return null;
    }

    // retrieve RGB color and color name by id
    @Override
    public Map<String, Object> getColorRGB(Long id) {
        // Warehouse car = this.findById(id);
        // if (car != null) {
        //     Map<String, Object> color = new HashMap<>();
        //     color.put("ColorName", car.getColorName());
        //     color.put("colorCode", car.getColorCode());
        //     return color;
        // }

        return null;
    }

    // Soft Delete a car
    @Override
    public Boolean delete(Long id) {
        // Warehouse car = this.findById(id);
        // if (car != null) {
        //     car.setDeleted(true);
        //     repository.save(car);
        //     return true;
        // }
        return false;
    }

    // utility method for carMapping objects
    private Warehouse carMapper(Warehouse car, Warehouse dto) {
        // car.setType(dto.getType() == null ? null : dto.getType());
        // car.setColorCode(dto.getColorCode() == null ? null : dto.getColorCode());
        // car.setColorName(dto.getColorName() == null ? null : dto.getColorName());
        // car.setPrice(dto.getPrice() == null ? null : dto.getPrice());
        // car.setType(dto.getType() == null ? null : dto.getType());
        // car.setYearOfConstruction(dto.getYearOfConstruction() == null ? null : dto.getYearOfConstruction());
        return car;
    }

    // car audit logs
    @Override
    public List<RevisionDto> getCarAudits(Long id) {
        Revisions<Integer, Warehouse> indList = repository.findRevisions(id);
        List<Revision<Integer, Warehouse>> cars = indList.getContent();

        List<RevisionDto> dtos = new ArrayList<>();
        for (Revision revision : cars) {
            dtos.add(new RevisionDto(revision.getEntity()));
        }

        return dtos;
    }

}
