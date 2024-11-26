package org.acme.service;

import org.acme.entity.M2MDevice;
import org.acme.exception.DeviceNotFoundException;

import java.util.List;

public interface DeviceService {
    M2MDevice getDeviceById(long id) throws DeviceNotFoundException;

    List<M2MDevice> getAllDevices();

    M2MDevice updateDevice(long id, M2MDevice user) throws DeviceNotFoundException;

    M2MDevice saveDevice(M2MDevice device);

    void deleteDevice(long id) throws DeviceNotFoundException;
}
