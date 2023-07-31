package com.met.metronome.user.exception;

public enum UserExceptionEnum {
    OK("성공"),
    NOT_FOUND_USER("아이디 또는 비밀번호가 다릅니다.");

    private String message;

    UserExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
