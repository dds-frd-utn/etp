/**
 * 
 */
package org.utn.frd.dds.etp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author jonatan.moreira
 *
 */
@Entity
@Table(name="commerces")
public class Commerce {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    @OneToMany(mappedBy = "uuid", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Local> locals;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Local> getLocals() {
        return locals;
    }

    public void setLocals(List<Local> locals) {
        this.locals = locals;
    }

    @Override
    public String toString() {
        return "Commerce{" +
                "uuid='" + uuid + '\'' +
                ", locals=" + locals +
                '}';
    }

}
