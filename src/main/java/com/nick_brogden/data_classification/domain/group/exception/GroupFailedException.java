package com.nick_brogden.data_classification.domain.group.exception;

public class GroupFailedException extends RuntimeException {
    public GroupFailedException(String message) {
        super(message);
    }
}
