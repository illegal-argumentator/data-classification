package com.nick_brogden.data_classification.domain.group.exception;

public class GroupIsInProgressException extends RuntimeException {
    public GroupIsInProgressException(String message) {
        super(message);
    }
}
