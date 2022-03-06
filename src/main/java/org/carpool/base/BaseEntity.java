package org.carpool.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
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
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "active", length = 1, nullable = true)
    private boolean active;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted = false;
}
