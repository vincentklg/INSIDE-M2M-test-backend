package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.exception.DeviceNotFoundException;
import org.acme.repository.DeviceRepository;
import org.acme.entity.M2MDevice;

import java.util.List;

@ApplicationScoped
public class M2MDeviceService implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Inject
    public M2MDeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public M2MDevice getDeviceById(long id) throws DeviceNotFoundException {
        return deviceRepository.findByIdOptional(id)
                .orElseThrow(() -> new DeviceNotFoundException("This device doesn't exist"));
    }

    @Override
    public List<M2MDevice> getAllDevices() {
        return deviceRepository.listAll();
    }

    @Transactional
    @Override
    public M2MDevice updateDevice(long id, M2MDevice device) throws DeviceNotFoundException {
        M2MDevice existingDevice = getDeviceById(id);
        existingDevice.setExternalId(device.externalId);
        existingDevice.setCreated(device.created);
        existingDevice.setConnectionType(device.connectionType);
        deviceRepository.persist(existingDevice);
        return existingDevice;
    }

    @Transactional
    @Override
    public M2MDevice saveDevice(M2MDevice device) {
        deviceRepository.persistAndFlush(device);
        return device;
    }

    public void deleteDevice(long id) throws DeviceNotFoundException{
        deviceRepository.delete(getDeviceById(id));
    }

}