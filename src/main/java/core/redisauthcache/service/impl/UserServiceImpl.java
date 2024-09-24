package core.redisauthcache.service.impl;

import core.redisauthcache.Dto.UserDto;
import core.redisauthcache.Dto.UserRegisterDto;
import core.redisauthcache.model.Role;
import core.redisauthcache.model.User;
import core.redisauthcache.repository.RoleRepository;
import core.redisauthcache.repository.UserRepository;
import core.redisauthcache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public UserDto registerUser(UserRegisterDto userRegisterDto) {
        if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
            throw new RuntimeException(String.format("User with email %s already exists", userRegisterDto.getEmail()));
        }
        User user = mapToEntity(userRegisterDto);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        Role roleUser = roleRepository.findByName("ADMIN");
        user.setRole(roleUser);
        userRepository.save(user);
        return mapToDto(user);
    }

    private User mapToEntity(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUsername(userRegisterDto.getUsername());
        user.setEmail(userRegisterDto.getEmail());
        return user;
    }

    private UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setRole(user.getRole().getName());
        return userDto;
    }
}
