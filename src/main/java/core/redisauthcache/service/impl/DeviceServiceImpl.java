package core.redisauthcache.service.impl;

import com.github.javafaker.Faker;
import core.redisauthcache.es.model.ESDevice;
import core.redisauthcache.es.service.DeviceESService;
import core.redisauthcache.model.Device;
import core.redisauthcache.repository.DeviceRepository;
import core.redisauthcache.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceESService deviceESService;
    private final Faker faker;
    private final ExecutorService executorService = Executors.newWorkStealingPool(10);

    @Override
    public void saveDevices() {
        for (int i = 0; i < 100; i++) {
            List<Device> devices = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                Device d = Device.builder()
                        .name(faker.commerce().productName())
                        .color(faker.color().name())
                        .price(faker.number().randomDigit())
                        .discount(faker.bool().bool())
                        .weight(faker.number().randomDouble(2, 1, 10))
                        .build();
                devices.add(d);
            }
            executorService.submit(() -> saveBatch(devices));
        }
        executorService.shutdown();
    }

    @Override
    public List<Device> getDevicesByName(String name) {
        Page<ESDevice> devicesByName = deviceESService.getDevicesByName(name);
        List<String> list = devicesByName.get().map(ESDevice::getId).toList();
        return deviceRepository.findAllById(list);
    }

    private void saveBatch(List<Device> devices){
        List<Device> devices1 = deviceRepository.saveAll(devices);
        deviceESService.saveDevice(devices1);
    }
}
