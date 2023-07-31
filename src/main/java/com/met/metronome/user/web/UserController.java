package com.met.metronome.user.web;

import com.google.gson.Gson;
import com.met.metronome.user.entity.UserDTO;
import com.met.metronome.user.entity.UserResponseDTO;
import com.met.metronome.user.exception.UserException;
import com.met.metronome.user.exception.UserExceptionEnum;
import com.met.metronome.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public ResponseEntity<UserResponseDTO> login(UserDTO user) {
        try {
            Gson gson = new Gson();
            String userJson = gson.toJson(userService.processLogin(user));

            UserResponseDTO userResponse = UserResponseDTO.builder()
                    .userInfo(userJson)
                    .message(UserExceptionEnum.OK.getMessage())
                    .build();
            return ResponseEntity.ok().body(userResponse);
        } catch (UserException e) {
            UserResponseDTO userResponse = UserResponseDTO.builder()
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(userResponse);
        }
    }
}
