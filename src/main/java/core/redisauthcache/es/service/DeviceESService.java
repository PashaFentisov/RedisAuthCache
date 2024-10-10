package core.redisauthcache.es.service;

import core.redisauthcache.es.model.Device;
import org.springframework.data.domain.Page;

public interface DeviceESService {

    void saveDevice(String deviceName);
    Page<Device> getDevicesByName(String deviceName);
    Page<Device> getDevicesByNameFuzzy(String deviceName);

    Iterable<Device> getAllDevices();
}
