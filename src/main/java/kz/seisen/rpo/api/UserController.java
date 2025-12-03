package kz.seisen.rpo.api;


import kz.seisen.rpo.models.UserModel;
import kz.seisen.rpo.services.impl.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final MyUserService userService;


    @GetMapping
    public String test() {
        return "test";
    }


    @PostMapping("/register")
    public void register(@RequestBody UserModel userModel) {
        userService.register(userModel);
    }
}
