package org.acme.repository;

import org.acme.entity.M2MDevice;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeviceRepository implements  PanacheRepository<M2MDevice>{
}
