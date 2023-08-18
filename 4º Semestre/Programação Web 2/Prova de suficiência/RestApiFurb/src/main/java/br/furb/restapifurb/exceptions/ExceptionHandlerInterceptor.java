package br.furb.restapifurb.exceptions;

import br.furb.restapifurb.exceptions.runtime.*;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionHandlerInterceptor extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseError(FormatException formatException) {
        return new ResponseEntity<>(formatException, HttpStatus.valueOf(formatException.getStatus()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<FormatException> badRequestException(BadRequestException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new FormatException(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST.value(),
                    System.currentTimeMillis()
                )
        );
    }

    @ExceptionHandler(ConflitedException.class)
    public ResponseEntity<FormatException> conflitedException(ConflitedException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new FormatException(
                        HttpStatus.CONFLICT.value(),
                        e.getMessage(),
                        HttpStatus.CONFLICT.value(),
                        System.currentTimeMillis()
                )
        );
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<FormatException> internalServerException(InternalServerException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new FormatException(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        e.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        System.currentTimeMillis()
                )
        );
    }

    @ExceptionHandler(NotAuthorizationException.class)
    public ResponseEntity<FormatException> notAuthorizationException(NotAuthorizationException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new FormatException(
                        HttpStatus.UNAUTHORIZED.value(),
                        e.getMessage(),
                        HttpStatus.UNAUTHORIZED.value(),
                        System.currentTimeMillis()
                )
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<FormatException> notFoundException(NotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new FormatException(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage(),
                        HttpStatus.NOT_FOUND.value(),
                        System.currentTimeMillis()
                )
        );
    }

    @ExceptionHandler(JwtExpiredException.class)
    public ResponseEntity<FormatException> jwtExpiredException(JwtExpiredException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                new FormatException(
                        HttpStatus.FORBIDDEN.value(),
                        e.getMessage(),
                        HttpStatus.FORBIDDEN.value(),
                        System.currentTimeMillis()
                )
        );
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<FormatException> unauthorizedException(HttpClientErrorException.Unauthorized e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new FormatException(
                        HttpStatus.UNAUTHORIZED.value(),
                        e.getMessage(),
                        HttpStatus.UNAUTHORIZED.value(),
                        System.currentTimeMillis()
                )
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<FormatException> userServerError(AccessDeniedException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new FormatException(
                        HttpStatus.UNAUTHORIZED.value(),
                        "Você não tem autorização para acessar esse serviço",
                        HttpStatus.UNAUTHORIZED.value(),
                        System.currentTimeMillis()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FormatException> exception(Exception e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new FormatException(
                        HttpStatus.UNAUTHORIZED.value(),
                        e.getMessage(),
                        HttpStatus.UNAUTHORIZED.value(),
                        System.currentTimeMillis()
                )
        );
    }
}

