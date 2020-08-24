package com.rau.learning.auth.springsecurityjwt.ctrl;

import com.rau.learning.auth.springsecurityjwt.dto.RegistrationDto;
import com.rau.learning.auth.springsecurityjwt.dto.UserDto;
import com.rau.learning.auth.springsecurityjwt.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Home Page")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")})
// annotation used to pass token from swagger header for key=Authorization that get intercepted by filter. Pass "Bearer "+<Token> in header from swagger.
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String firstPage() {
        return "Hello World";
    }

    @ApiOperation(value = "login page")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        String jwtToken = userService.login(userDto.getUserName(), userDto.getPassword());
        return ResponseEntity.ok(jwtToken);
    }

    @ApiOperation(value = "Register new person")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody RegistrationDto registrationDto) {
        String message = userService.signup(registrationDto);
        return ResponseEntity.ok(message);
    }

}
