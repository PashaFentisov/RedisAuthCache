package core.redisauthcache.service;

import core.redisauthcache.model.Device;

import java.util.List;

public interface DeviceService {
    void saveDevices();

    List<Device> getDevicesByName(String name);
}
