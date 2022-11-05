package com.gerimedica.task.exception;

public enum ExceptionMessagesEnum {

    FILE_IS_EMPTY("file is empty"),
    NOT_FOUND("not found record"),

    UNKNOWN_EXCEPTION("happen something wrong...");


    private final String message;

    ExceptionMessagesEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
