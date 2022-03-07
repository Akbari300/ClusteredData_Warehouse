package org.progresssoft.warehouse;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.progresssoft.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Akbari300
 */
@Audited
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse")
@Entity(name = "Warehouse")
@Where(clause = "deleted is not true")
public class Warehouse extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warehouse_tbl_generator")
    @SequenceGenerator(name = "warehouse_tbl_generator", sequenceName = "warehouse_tbl_seq", allocationSize = 1)
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(unique = true, name = "deal_id", nullable = false)
    private String dealId;


    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "order_currency_code", nullable = false, length = 3)
    private String orderCurrencyCode;

    @Column(name = "exchange_currency_code", nullable = false, length = 3)
    private String exchangeCurrencyCode;

}
