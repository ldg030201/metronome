package com.met.metronome.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id; //유저 고유 ID
    private String loginId; //로그인 ID
    private String password; //비밀번호
    private String name; //이름
}
