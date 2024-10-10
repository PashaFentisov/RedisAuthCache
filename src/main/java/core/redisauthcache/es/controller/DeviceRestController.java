package core.redisauthcache.es.controller;

import core.redisauthcache.es.dto.RequestDeviceSavingDto;
import core.redisauthcache.es.model.Device;
import core.redisauthcache.es.service.DeviceESService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/device")
@RestController
@AllArgsConstructor
public class DeviceRestController {
    private final DeviceESService deviceESService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveDevice(@RequestBody RequestDeviceSavingDto device) {
        deviceESService.saveDevice(device.getDeviceName());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<Device>> getDevicesByName(@RequestParam String name) {
        Page<Device> devicesByName = deviceESService.getDevicesByName(name);
        return ResponseEntity.ok(devicesByName);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Device>> getAllDevices() {
        return ResponseEntity.ok(deviceESService.getAllDevices());
    }

    @GetMapping("/fuzzy")
    public ResponseEntity<Page<Device>> getDevicesByNameFuzzy(@RequestParam String name) {
        Page<Device> devicesByName = deviceESService.getDevicesByNameFuzzy(name);
        return ResponseEntity.ok(devicesByName);
    }
}
