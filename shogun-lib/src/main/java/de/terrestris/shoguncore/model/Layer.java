package de.terrestris.shoguncore.model;

import de.terrestris.shoguncore.enumeration.LayerType;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import de.terrestris.shoguncore.model.jsonb.LayerClientConfig;
import de.terrestris.shoguncore.model.jsonb.LayerFeature;
import de.terrestris.shoguncore.model.jsonb.LayerSourceConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

@Entity(name = "layers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Layer extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private LayerClientConfig clientConfig;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    private LayerSourceConfig sourceConfig;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private List<LayerFeature> features;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LayerType type;

}
