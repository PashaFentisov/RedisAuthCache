package core.redisauthcache.Dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserRegisterDto {
    private String username;
    private String password;
    private String email;
}
