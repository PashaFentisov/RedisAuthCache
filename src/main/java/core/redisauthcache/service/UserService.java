package core.redisauthcache.service;

import core.redisauthcache.Dto.UserDto;
import core.redisauthcache.Dto.UserRegisterDto;
import core.redisauthcache.model.User;

public interface UserService {
    User findByUsername(String username);

    UserDto registerUser(UserRegisterDto userRegisterDto);
}
