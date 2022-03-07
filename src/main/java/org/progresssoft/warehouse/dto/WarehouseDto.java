package org.progresssoft.warehouse.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author Akbari300
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDto {

    @JsonProperty(required = true)
    private String dealId;

    @JsonProperty(required = true)
    private BigDecimal amount;

    @JsonProperty(required = true)
    @Size(max= 3, min=3, message = "orderCurrencyCode takes 3 letters")
    private String orderCurrencyCode;

    @JsonProperty(required = true)
    @Size(max= 3, min=3, message = "exchangeCurrencyCode code takes 3 letters")
    private String exchangeCurrencyCode;

}
