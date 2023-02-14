package com.baha.TrainingPlatformEE.Exceptions;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

private ErrorCode errorCode ;
// we will be creating Constructors depending on our parameters !!
    public EntityNotFoundException(String message)
    {
        super(message);
    }
    public EntityNotFoundException(String message , Throwable cause )
    {
        super(message, cause);
    }
    public EntityNotFoundException(String message , Throwable cause , ErrorCode errorCode)
    {
        super(message, cause);

        this.errorCode = errorCode ;
    }
    public EntityNotFoundException(String message , ErrorCode errorCode)
    {
        super(message) ;
        this.errorCode = errorCode ;
    }
}
