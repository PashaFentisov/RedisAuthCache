package core.redisauthcache.service.impl;

import core.redisauthcache.service.TestLoggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestLoggingServiceImpl implements TestLoggingService {

    @Override
    public void testLogs(){
        log.info("TEST INFO LOG");
    }
}
