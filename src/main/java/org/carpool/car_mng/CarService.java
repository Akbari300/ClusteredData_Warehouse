package org.carpool.car_mng;

import java.util.List;
import java.util.Map;

import org.carpool.util.RevisionDto;

public interface CarService {
    public List<Car> findAll();

    public Car findById(Long id);

    public Car create(Car dto);

    public Boolean delete(Long id);

    public Car update(Long id, Car car);

    public Map<String, Object> getColorRGB(Long id);

    public List<RevisionDto> getCarAudits(Long id);
}
