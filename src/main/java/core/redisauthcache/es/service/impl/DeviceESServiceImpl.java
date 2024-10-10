package core.redisauthcache.es.service.impl;

import core.redisauthcache.es.model.Device;
import core.redisauthcache.es.repository.DeviceESRepository;
import core.redisauthcache.es.service.DeviceESService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeviceESServiceImpl implements DeviceESService {

    private final DeviceESRepository deviceESRepository;

    @Override
    public void saveDevice(String deviceName) {
        Device d = new Device();
        d.setName(deviceName);
        deviceESRepository.save(d);
    }

    @Override
    public Page<Device> getDevicesByName(String deviceName) {
        PageRequest pageRequest = PageRequest.of(0, 100);
        return deviceESRepository.findByName(deviceName, pageRequest);
    }

    @Override
    public Iterable<Device> getAllDevices() {
        return deviceESRepository.findAll();
    }

    @Override
    public Page<Device> getDevicesByNameFuzzy(String deviceName) {
        PageRequest pageRequest = PageRequest.of(0, 100);
        return deviceESRepository.findByNameFuzzy(deviceName, pageRequest);
    }
}
