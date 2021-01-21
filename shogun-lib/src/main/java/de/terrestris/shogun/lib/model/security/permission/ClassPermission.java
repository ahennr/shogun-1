package de.terrestris.shogun.lib.model.security.permission;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;


import de.terrestris.shogun.lib.model.BaseEntity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

@MappedSuperclass
@Audited
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public abstract class ClassPermission extends BaseEntity {

    @Column
    private String className;

    /**
     * Attention: Hibernate will create an unwanted UNIQUE constraint for the join column <i>permissions_id</i> if
     *            in create mode. To prevent unique constraint violations the constraint has to be removed manually.
     */
    @OneToOne(
        optional = false,
        fetch = FetchType.LAZY
    )
    @Fetch(FetchMode.JOIN)
    @Audited(targetAuditMode = NOT_AUDITED)
    private PermissionCollection permissions;

}