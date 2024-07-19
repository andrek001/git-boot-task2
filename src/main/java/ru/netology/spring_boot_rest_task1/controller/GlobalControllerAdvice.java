package ru.netology.spring_boot_rest_task1.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.netology.spring_boot_rest_task1.exception.ApiError;
import ru.netology.spring_boot_rest_task1.exception.InvalidCredentials;
import ru.netology.spring_boot_rest_task1.exception.UnauthorizedUser;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handleUnauthorizedUser(final UnauthorizedUser unauthorizedUser) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
                body(unauthorizedUser.getMessage());


    }

    @ExceptionHandler({InvalidCredentials.class, MissingServletRequestParameterException.class, MethodArgumentNotValidException.class})
    ResponseEntity<ApiError> handleBadRequestException(final Exception exception) {
        ApiError error = new ApiError(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body(error);

    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    private ApiError handleError(final HttpServletRequest request,
                                 final HttpServletResponse response,
                                 final Exception ex) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ApiError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis());
    }


}
