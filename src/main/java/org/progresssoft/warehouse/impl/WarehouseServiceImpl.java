package org.progresssoft.warehouse.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.progresssoft.util.RevisionDto;
import org.progresssoft.warehouse.Warehouse;
import org.progresssoft.warehouse.WarhouseRepository;
import org.progresssoft.warehouse.WarehouseService;
import org.progresssoft.warehouse.dto.WarehouseDto;
import org.progresssoft.warehouse.dto.WarehouseDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Akbari300
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarhouseRepository repository;

    // retrieve all deals
    @Override
    public List<Warehouse> findAll() {
        return repository.findAll();
    }

    // retrieve deal by id
    @Override
    public Warehouse findById(Long id) {
        Optional<Warehouse> warehouse = repository.findById(id);
        if (warehouse.isPresent())
            return warehouse.get();
        return null;
    }

    // create new deal
    @Override
    public Object create(WarehouseDto dto){
        try{
            Warehouse warehouse = WarehouseDtoMapper.mapWarehouseDto(new Warehouse(), dto);
             if (warehouse != null) {
                 return repository.save(warehouse);
            }
            return null;
        }catch(Exception  e){
            return "duplicate (dealId) = " + dto.getDealId();
        }   
        
    }


    // create multiple deals
    @Override
    public Object createAll(WarehouseDto [] dtos) {
        try{
            for (WarehouseDto dto : dtos) {
                Warehouse warehouse = WarehouseDtoMapper.mapWarehouseDto(new Warehouse(), dto);
                if (warehouse != null) {
                    repository.save(warehouse);
                 }
            }
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "update dealID";
        }
        
    }

    // update an existing deal info
    @Override
    public Warehouse update(Long id, WarehouseDto dto) {
        Optional<Warehouse> pOptional = repository.findById(id);
        if (pOptional.isPresent()) {
            Warehouse warehouse = WarehouseDtoMapper.mapWarehouseDto(pOptional.get(), dto);
            if (!warehouse.equals(null)) {
                return repository.save(warehouse);
            }
        }

        return null;
    }

    // Soft Delete a deal 
    @Override
    public Boolean delete(Long id) {
        Optional<Warehouse> objOptional = repository.findById(id);

        if (objOptional.isPresent()) {
            Warehouse warehouse = objOptional.get();
            warehouse.setDeleted(true);
            warehouse.setDeletedAt(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            repository.save(warehouse);
            return true;
        }
        return false;
    }


    // deal audit logs
    @Override
    public List<RevisionDto> getWareHouseAudits(Long id) {
        Revisions<Integer, Warehouse> indList = repository.findRevisions(id);
        List<Revision<Integer, Warehouse>> warehouses = indList.getContent();

        List<RevisionDto> dtos = new ArrayList<>();
        for (Revision revision : warehouses) {
            dtos.add(new RevisionDto(revision.getEntity()));
        }

        return dtos;
    }

}
