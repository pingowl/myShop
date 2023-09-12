package com.myshop.myShop.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Post 예외
    NOT_FOUND_POST(HttpStatus.NOT_FOUND, "해당 게시판 글을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String detail;
}
