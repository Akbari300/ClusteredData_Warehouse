package org.progresssoft.warehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

/**
 *
 * @author Akbari300
 */
public interface WarhouseRepository extends JpaRepository<Warehouse, Long>, RevisionRepository<Warehouse, Long, Integer> {
}
