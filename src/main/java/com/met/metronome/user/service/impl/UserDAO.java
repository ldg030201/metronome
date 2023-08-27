package com.met.metronome.user.service.impl;

import com.met.metronome.user.entity.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    UserDTO processLogin(UserDTO user);

    UserDTO selectUserFromLoginId(String loginId);

    void insertUser(UserDTO user);
}
