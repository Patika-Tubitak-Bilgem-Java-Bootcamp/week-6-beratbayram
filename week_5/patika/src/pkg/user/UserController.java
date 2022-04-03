package pkg.user;

import pkg.Msg;
import pkg.Login;
import pkg.Payment;
import pkg.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/register")
    public Msg register(@RequestBody @Valid User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Msg login(@RequestBody @Valid Login request) {
        return userService.login(request.getTc(), request.getPassword());
    }

    @PostMapping("/payCredit")
    public Msg payCredit(@RequestBody @Valid Payment request) {
        return userService.payCredit(request.getTc(), request.getAmount());
    }

    @PostMapping("/payExtress")
    public Msg payExtress(@RequestBody @Valid Payment request) {
        return userService.payCreditExtres(request.getTc(), request.getAmount());
    }

    @PostMapping("/send")
    public Msg send(@RequestBody @Valid Request request) {
        return userService.send(request.getSenderTc(),request.getReceiverTc(),request.getAmount());
    }
}
