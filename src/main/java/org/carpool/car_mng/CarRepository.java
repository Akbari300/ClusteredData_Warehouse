package org.carpool.car_mng;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

/**
 *
 * @author Akbari300
 */
public interface CarRepository extends JpaRepository<Car, Long>, RevisionRepository<Car, Long, Integer> {
}
