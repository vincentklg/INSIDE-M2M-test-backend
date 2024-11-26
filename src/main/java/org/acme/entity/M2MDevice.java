package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.acme.ConnectionType;

import java.util.Date;

/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 *     @Inject
 *     EntityManager em;
 *
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         em.persist(entity1);
 *
 *         List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 *     }
 * }
 */
@Entity
@Table(name = "devices")
public class M2MDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "external_id", nullable = false)
    @JsonProperty("external_id")
    public String externalId;

    @Column(name = "created", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("created")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date created;

    @Enumerated(EnumType.STRING)
    @Column(name = "connection_type", nullable = false)
    @JsonProperty("connection_type")
    public ConnectionType connectionType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String exId) {
        this.externalId = exId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date newCreated) {
        this.created = newCreated;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType newConn) {
        this.connectionType = newConn;
    }
}
