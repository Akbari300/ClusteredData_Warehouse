package org.carpool.car_mng.impl;

import org.carpool.car_mng.Car;
import org.carpool.car_mng.CarRepository;
import org.carpool.car_mng.CarService;
import org.carpool.util.RevisionDto;
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
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository repository;

    // retrieve all cars
    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    // retrieve car by id
    @Override
    public Car findById(Long id) {
        Optional<Car> car = repository.findById(id);
        if (car.isPresent())
            return car.get();
        return null;
    }

    // create new car
    @Override
    public Car create(Car car) {
        if (car != null) {
            return repository.save(car);
        }
        return null;
    }

    // update an existing car info
    @Override
    public Car update(Long id, Car dto) {
        Car car = this.findById(id);
        if (car != null) {
            return repository.save(this.carMapper(car, dto));
        }
        return null;
    }

    // retrieve RGB color and color name by id
    @Override
    public Map<String, Object> getColorRGB(Long id) {
        Car car = this.findById(id);
        if (car != null) {
            Map<String, Object> color = new HashMap<>();
            color.put("ColorName", car.getColorName());
            color.put("colorCode", car.getColorCode());
            return color;
        }

        return null;
    }

    // Soft Delete a car
    @Override
    public Boolean delete(Long id) {
        Car car = this.findById(id);
        if (car != null) {
            car.setDeleted(true);
            repository.save(car);
            return true;
        }
        return false;
    }

    // utility method for carMapping objects
    private Car carMapper(Car car, Car dto) {
        car.setType(dto.getType() == null ? null : dto.getType());
        car.setColorCode(dto.getColorCode() == null ? null : dto.getColorCode());
        car.setColorName(dto.getColorName() == null ? null : dto.getColorName());
        car.setPrice(dto.getPrice() == null ? null : dto.getPrice());
        car.setType(dto.getType() == null ? null : dto.getType());
        car.setYearOfConstruction(dto.getYearOfConstruction() == null ? null : dto.getYearOfConstruction());
        return car;
    }

    // car audit logs
    @Override
    public List<RevisionDto> getCarAudits(Long id) {
        Revisions<Integer, Car> indList = repository.findRevisions(id);
        List<Revision<Integer, Car>> cars = indList.getContent();

        List<RevisionDto> dtos = new ArrayList<>();
        for (Revision revision : cars) {
            dtos.add(new RevisionDto(revision.getEntity()));
        }

        return dtos;
    }

}
