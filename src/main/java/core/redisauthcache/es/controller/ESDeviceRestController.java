package core.redisauthcache.es.controller;

import core.redisauthcache.es.model.ESDevice;
import core.redisauthcache.es.service.DeviceESService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/es/device")
@RestController
@AllArgsConstructor
public class ESDeviceRestController {
    private final DeviceESService deviceESService;

//    @PostMapping("/save")
//    public ResponseEntity<Object> saveDevice(@RequestBody RequestDeviceSavingDto device) {
//        deviceESService.saveDevice(device.getDeviceName());
//        return ResponseEntity.ok().build();
//    }

    @GetMapping
    public ResponseEntity<Page<ESDevice>> getDevicesByName(@RequestParam String name) {
        Page<ESDevice> devicesByName = deviceESService.getDevicesByName(name);
        return ResponseEntity.ok(devicesByName);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ESDevice>> getAllDevices() {
        return ResponseEntity.ok(deviceESService.getAllDevices());
    }

    @GetMapping("/fuzzy")
    public ResponseEntity<Page<ESDevice>> getDevicesByNameFuzzy(@RequestParam String name) {
        Page<ESDevice> devicesByName = deviceESService.getDevicesByNameFuzzy(name);
        return ResponseEntity.ok(devicesByName);
    }
}
