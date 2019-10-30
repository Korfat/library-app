package library.controller;

import javax.validation.Valid;

import library.dto.UserRegistrationDto;
import library.entity.Role;
import library.entity.User;
import library.service.RoleService;
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
    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public String addUserPage(Model model) {
        model.addAttribute("userDto", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute @Valid UserRegistrationDto userDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "User creating error");
            return "registration";
        }
        userService.add(dtoToEntity(userDto));
        return "login";
    }

    private User dtoToEntity(UserRegistrationDto userDto) {
        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setSurname(userDto.getSurname());
        newUser.setEmail(userDto.getEmail());
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());

        Role role = roleService.getRoleByName(ROLE_USER).get();
        newUser.getRoles().add(role);
        return newUser;
    }
}
