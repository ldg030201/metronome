package com.met.metronome.user.service.impl;

import com.met.metronome.user.entity.UserDTO;
import com.met.metronome.user.exception.UserException;
import com.met.metronome.user.exception.UserExceptionEnum;
import com.met.metronome.user.service.UserService;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDTO processLogin(UserDTO user) throws UserException {
        UserDTO resultUser = userDAO.processLogin(user);

        if (resultUser == null) {
            throw new UserException(UserExceptionEnum.NOT_FOUND_USER.getMessage());
        }

        return resultUser;
    }
}
