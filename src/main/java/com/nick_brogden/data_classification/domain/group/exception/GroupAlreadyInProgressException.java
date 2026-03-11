package com.nick_brogden.data_classification.domain.group.exception;

public class GroupAlreadyInProgressException extends RuntimeException {
    public GroupAlreadyInProgressException(String message) {
        super(message);
    }
}
