package org.progresssoft.warehouse;

import java.util.List;
import java.util.Map;

import org.progresssoft.util.RevisionDto;
import org.progresssoft.warehouse.dto.WarehouseDto;

public interface WarehouseService {
    public List<Warehouse> findAll();

    public Warehouse findById(Long id);

    public Object create(WarehouseDto dto);

    public Boolean createAll(WarehouseDto [] dto);

    public Boolean delete(Long id);

    public Warehouse update(Long id, WarehouseDto car);

    public List<RevisionDto> getWareHouseAudits(Long id);
}
