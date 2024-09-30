package core.redisauthcache.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomSessionServiceImpl {

    private final FindByIndexNameSessionRepository<? extends Session> sessions;

    public void removeSession(String email) {
        Set<String> usersSessionIds = sessions.findByPrincipalName(email).keySet();
        usersSessionIds.forEach(sessions::deleteById);
    }
}
