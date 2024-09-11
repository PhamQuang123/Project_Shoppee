package example.shoppee.controller;

import example.shoppee.dto.request.UserInfoSignup;
import example.shoppee.dto.response.ResponseData;
import example.shoppee.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/shoppee/users")
public class AuthController {

    private final UserService userService;

    private String getPathUrl(HttpServletRequest request) {
        String path = request.getRequestURI();
        return  path;
    }

    @PostMapping("/signup")
    public ResponseData<?> signUp(@Valid @RequestBody UserInfoSignup userInfoSignup, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            ResponseData<UserInfoSignup> response = new ResponseData<UserInfoSignup>(new Date(),HttpStatus.BAD_REQUEST.value(), "registration failed", userInfoSignup, getPathUrl(request));
            return response;
        }

        UserInfoSignup userInfoSignup1 = userService.saveUser(userInfoSignup);
        ResponseData<UserInfoSignup> response = new ResponseData<>();
        response.setData(userInfoSignup1);
        response.setTimestamp(new Date());
        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("Signup successful");
        return response;

    }
    
}
