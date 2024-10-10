package core.redisauthcache.es.service.impl;

import core.redisauthcache.es.model.ESDevice;
import core.redisauthcache.es.repository.DeviceESRepository;
import core.redisauthcache.es.service.DeviceESService;
import core.redisauthcache.model.Device;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeviceESServiceImpl implements DeviceESService {

    private final DeviceESRepository deviceESRepository;

    @Override
    public void saveDevice(List<Device> devices) {
        deviceESRepository.saveAll(mapDevices(devices));
    }

    private List<ESDevice> mapDevices(List<Device> devices) {
        return devices.stream().map(device -> {
            ESDevice esDevice = new ESDevice();
            esDevice.setId(device.getId());
            esDevice.setName(device.getName());
            return esDevice;
        }).toList();
    }

    @Override
    public Page<ESDevice> getDevicesByName(String deviceName) {
        PageRequest pageRequest = PageRequest.of(0, 10);
        return deviceESRepository.findByName(deviceName, pageRequest);
    }

    @Override
    public Iterable<ESDevice> getAllDevices() {
        return deviceESRepository.findAll();
    }

    @Override
    public Page<ESDevice> getDevicesByNameFuzzy(String deviceName) {
        PageRequest pageRequest = PageRequest.of(0, 100);
        return deviceESRepository.findByNameFuzzy(deviceName, pageRequest);
    }
}
