package com.met.metronome.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private String userInfo;
    private String message;

    public UserResponseDTO(String userInfo, String message) {
        this.userInfo = userInfo;
        this.message = message;
    }
}
