package org.carpool.car_mng;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.carpool.base.BaseEntity;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
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
@Table(name = "car")
@Entity(name = "Car")
@Where(clause = "deleted is not true")
public class Car extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_tbl_generator")
    @SequenceGenerator(name = "car_tbl_generator", sequenceName = "car_tbl_seq", allocationSize = 1)
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;

    // type = EUR/USD
    @Column
    private String type;

    @Column
    private String colorName;

    @Column
    private String colorCode;

    @Column
    private String yearOfConstruction;

    @Column
    private Double price;

    @Column
    private String notes;

}
