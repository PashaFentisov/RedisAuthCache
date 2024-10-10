package core.redisauthcache.controller;

import core.redisauthcache.model.Device;
import core.redisauthcache.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("device")
@RequiredArgsConstructor
public class DeviceRestController {
    private final DeviceService deviceService;

    @PostMapping
    public void saveDevice(){
        deviceService.saveDevices();
    }

    @GetMapping("/byName")
    public List<Device> getDevicesByName(@RequestParam String name){
        return deviceService.getDevicesByName(name);
    }
}
