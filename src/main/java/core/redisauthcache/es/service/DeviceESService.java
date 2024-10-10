package core.redisauthcache.es.service;

import core.redisauthcache.es.model.ESDevice;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeviceESService {

    void saveDevice(List<core.redisauthcache.model.Device> devices1);
    Page<ESDevice> getDevicesByName(String deviceName);
    Page<ESDevice> getDevicesByNameFuzzy(String deviceName);

    Iterable<ESDevice> getAllDevices();
}
