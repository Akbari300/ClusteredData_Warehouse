package org.progresssoft.warehouse.dto;

import org.progresssoft.warehouse.Warehouse;

/**
 *
 * @author Akbari300
 */
public class WarehouseDtoMapper {
    public static Warehouse mapWarehouseDto(Warehouse warehouse, WarehouseDto dto){ 

        try{
            warehouse.setActive(true);
            warehouse.setAmount(dto.getAmount() != null? dto.getAmount() : null);
            warehouse.setDealId(dto.getDealId() != null? dto.getDealId() : null);
            warehouse.setOrderCurrencyCode(dto.getOrderCurrencyCode() != null? dto.getOrderCurrencyCode() : null);
            warehouse.setExchangeCurrencyCode(dto.getExchangeCurrencyCode() != null? dto.getExchangeCurrencyCode(): null);
            return warehouse;
 
        }
        catch(Exception e){
            System.out.println("Exception in Mapping warehouse dto");
            return null;
        } 
     }
}
