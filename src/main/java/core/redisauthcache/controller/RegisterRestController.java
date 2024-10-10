package core.redisauthcache.controller;

import core.redisauthcache.dto.UserDto;
import core.redisauthcache.dto.UserRegisterDto;
import core.redisauthcache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterRestController {
    private final UserService userService;

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegisterDto userDTO, Model model) {
        userService.registerUser(userDTO);
        return "redirect:/login";
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegisterDto());
        return "register";
    }
}
