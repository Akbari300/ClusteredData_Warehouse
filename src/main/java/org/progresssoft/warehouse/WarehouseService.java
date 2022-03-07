package org.progresssoft.warehouse;

import java.util.List;
import java.util.Map;

import org.progresssoft.util.RevisionDto;

public interface WarehouseService {
    public List<Warehouse> findAll();

    public Warehouse findById(Long id);

    public Warehouse create(Warehouse dto);

    public Boolean delete(Long id);

    public Warehouse update(Long id, Warehouse car);

    public Map<String, Object> getColorRGB(Long id);

    public List<RevisionDto> getCarAudits(Long id);
}
