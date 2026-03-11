package com.nick_brogden.data_classification.adapter.group.in;

import com.nick_brogden.data_classification.adapter.server.exception.ExceptionResponse;
import com.nick_brogden.data_classification.domain.group.exception.GroupAlreadyInProgressException;
import com.nick_brogden.data_classification.domain.group.exception.GroupFailedException;
import com.nick_brogden.data_classification.domain.group.exception.GroupIsInProgressException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GroupExceptionHandler {

    @ExceptionHandler(GroupAlreadyInProgressException.class)
    public ResponseEntity<ExceptionResponse> handleGroupAlreadyInProgressException(GroupAlreadyInProgressException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ExceptionResponse.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.CONFLICT.value())
                        .path(request.getRequestURI())
                        .build());
    }

    @ExceptionHandler(GroupFailedException.class)
    public ResponseEntity<ExceptionResponse> handleGroupFailedException(GroupFailedException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionResponse.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .path(request.getRequestURI())
                        .build());
    }

    @ExceptionHandler(GroupIsInProgressException.class)
    public ResponseEntity<ExceptionResponse> handleGroupIsInProgressException(GroupIsInProgressException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ExceptionResponse.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.OK.value())
                        .path(request.getRequestURI())
                        .build());
    }
}
