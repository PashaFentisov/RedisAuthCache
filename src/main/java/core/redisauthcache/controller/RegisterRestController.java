package core.redisauthcache.controller;

import core.redisauthcache.Dto.UserDto;
import core.redisauthcache.Dto.UserRegisterDto;
import core.redisauthcache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterRestController {
    private final UserService userService;

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegisterDto userDTO, Model model) {
        UserDto userDto = userService.registerUser(userDTO);
        return "redirect:/login";
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegisterDto());
        return "register";
    }
}
