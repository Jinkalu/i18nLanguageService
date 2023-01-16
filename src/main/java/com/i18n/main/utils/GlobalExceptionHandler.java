package com.i18n.main.utils;

import com.i18n.main.utils.vo.ApiException;
import com.i18n.main.utils.vo.ErrorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorVO>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorVO> errors = exception.getBindingResult().getAllErrors().stream().map(objectError ->
                        ErrorVO.builder()
                                .fieldName(((FieldError) objectError).getField())
                                .message(List.of(Objects.requireNonNull(objectError.getDefaultMessage())))
                                .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ApiExceptionHandler.class})
    public ResponseEntity<List<ApiException>> handleApiRequestException(ApiExceptionHandler e) {
        ApiException apiException = ApiException.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(List.of(apiException));
    }
}
