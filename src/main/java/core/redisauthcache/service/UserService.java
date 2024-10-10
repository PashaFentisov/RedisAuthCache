package core.redisauthcache.service;

import core.redisauthcache.dto.UserDto;
import core.redisauthcache.dto.UserRegisterDto;
import core.redisauthcache.model.User;

public interface UserService {
    User findByUsername(String username);

    UserDto registerUser(UserRegisterDto userRegisterDto);
}
