package library.controller;

import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;

import library.dto.UserRegistrationDto;
import library.entity.Role;
import library.entity.User;
import library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String addUserPage(Model model) {
        model.addAttribute("userDto", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute @Valid UserRegistrationDto userDto,
                               BindingResult result, Model model) {
        User newUser = new User(userDto.getName(), userDto.getSurname(),
                userDto.getEmail(), userDto.getUsername(), userDto.getPassword());
        if (result.hasErrors()) {
            model.addAttribute("message", "User creating error");
            return "registration";
        }
        Set<Role> roles = new HashSet<>();
        Role role = new Role("ROLE_USER");
        roles.add(role);
        newUser.setRoles(roles);
        userService.add(newUser);
        return "login";
    }
}
