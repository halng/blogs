package com.thebasics.blogsapi.exceptions;

import com.thebasics.blogsapi.viewmodel.ResVm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ResVm> entityNotFoundExceptionHandler(
        EntityNotFoundException entityNotFoundException, WebRequest webRequest) {
        ResVm errorResVm = new ResVm(HttpStatus.NOT_FOUND.value(),
            entityNotFoundException.getMessage());
        LOG.error(errorResVm.data().toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResVm);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ResVm> badRequestExceptionHandler(BadRequestException badRequestException,
        WebRequest webRequest) {
        ResVm errorResVm = new ResVm(HttpStatus.BAD_REQUEST.value(),
            badRequestException.getMessage());
        LOG.error(errorResVm.data().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResVm);
    }

    @ExceptionHandler({AuthException.class})
    public ResponseEntity<ResVm> badCredentialExceptionHandler(
        AuthException authException, WebRequest webRequest) {
        ResVm errorResVm = new ResVm(HttpStatus.UNAUTHORIZED.value(),
            authException.getMessage());
        LOG.error(errorResVm.data().toString());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResVm);
    }
}
