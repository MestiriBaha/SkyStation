package com.baha.TrainingPlatformEE.Handlers;

import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.baha.TrainingPlatformEE.Handlers.ErrorDTO ;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException (EntityNotFoundException exception , WebRequest webrequest)
    {
        final HttpStatus NotFound = HttpStatus.NOT_FOUND ;
         final ErrorDTO errorDTO =    ErrorDTO.builder()
                    .errorcode(exception.getErrorCode())
            .HttpCode(NotFound.value())
            .Message(exception.getMessage())
            .build() ;
            //using error dto in the diamonds or not , won't affect !! spring already handles it !
        return new ResponseEntity<ErrorDTO>(errorDTO,NotFound) ;
    }
    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDTO> handleException (InvalidEntityException exception , WebRequest webRequest)
    {
       final HttpStatus BadRequest = HttpStatus.BAD_REQUEST ;
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .errorcode(exception.getErrorCode())
                .HttpCode(BadRequest.value())
                .Message(exception.getMessage())
                .errors(exception.getErrors())
                .build() ;
        return new ResponseEntity<>(errorDTO,BadRequest) ;
    }
}
