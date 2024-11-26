package core.redisauthcache.controller;

import core.redisauthcache.service.TestLoggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/logging")
public class TestLogingController {
    private final TestLoggingService testLoggingService;

    @GetMapping
    public ResponseEntity<Object> testLogging(){
        testLoggingService.testLogs();
        return ResponseEntity.status(200).build();
    }
}
