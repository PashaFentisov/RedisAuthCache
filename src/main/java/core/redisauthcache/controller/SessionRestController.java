package core.redisauthcache.controller;

import core.redisauthcache.service.impl.CustomSessionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionRestController {
    private final CustomSessionServiceImpl customSessionServiceImpl;

    @DeleteMapping("delete")
    public void getAllSessions(@RequestParam("email") String email) {
        customSessionServiceImpl.removeSession(email);
    }
}
