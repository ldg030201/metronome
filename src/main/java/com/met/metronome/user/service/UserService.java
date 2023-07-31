package com.met.metronome.user.service;

import com.met.metronome.user.entity.UserDTO;
import com.met.metronome.user.exception.UserException;

public interface UserService {
    UserDTO processLogin(UserDTO user) throws UserException;
}
