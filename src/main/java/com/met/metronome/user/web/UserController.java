package com.met.metronome.user.web;

import com.google.gson.Gson;
import com.met.metronome.user.entity.UserDTO;
import com.met.metronome.user.entity.UserResponseDTO;
import com.met.metronome.user.exception.UserException;
import com.met.metronome.user.exception.UserExceptionEnum;
import com.met.metronome.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserDTO user) {
        try {
            Gson gson = new Gson();
            String userJson = gson.toJson(userService.processLogin(user));

            UserResponseDTO userResponse = UserResponseDTO.builder()
                    .userInfo(userJson)
                    .message(UserExceptionEnum.OK.getMessage())
                    .build();
            return ResponseEntity.ok().body(userResponse);
        } catch (UserException e) {
            log.error(e.getMessage());
            UserResponseDTO userResponse = UserResponseDTO.builder()
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(userResponse);
        }
    }

    @GetMapping("/find-duplication-id")
    public ResponseEntity<Boolean> findDuplicationId(@RequestParam("loginId") String loginId) {
        try {
            UserDTO user = userService.selectUserFromLoginId(loginId);
            if (user == null) {
                return ResponseEntity.ok().body(false);
            } else {
                return ResponseEntity.ok().body(true);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<UserResponseDTO> registration(@RequestBody UserDTO user) {
        try {
            Gson gson = new Gson();
            String userJson = gson.toJson(userService.insertUser(user));

            UserResponseDTO userResponse = UserResponseDTO.builder()
                    .userInfo(userJson)
                    .message(UserExceptionEnum.OK.getMessage())
                    .build();
            return ResponseEntity.ok().body(userResponse);
        } catch (UserException e) {
            log.error(e.getMessage());
            UserResponseDTO userResponse = UserResponseDTO.builder()
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(userResponse);
        }
    }
}
