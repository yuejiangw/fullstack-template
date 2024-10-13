package com.yuejiangw.backend.exception;

import com.yuejiangw.backend.common.BaseResponse;
import com.yuejiangw.backend.common.ErrorCode;
import com.yuejiangw.backend.common.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public BaseResponse customExceptionHandler(CustomException e) {
        log.error("customException: {}. Description: {}", e.getMessage(), e.getDescription());
        return ResponseUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage(), e.getDescription());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse customExceptionHandler(RuntimeException e) {
        log.error("runtimeException: {}", e.getMessage());
        return ResponseUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage());
    }
}
