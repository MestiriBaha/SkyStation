package com.baha.TrainingPlatformEE.Exceptions;

public enum ErrorCode {
    COMPANY_NOT_FOUND(1000),
    COMPANY_NOT_VALID(1001),
    USER_NOT_FOUND(2000),
    USER_NOT_VALID(2001) ,
    SKIER_NOT_FOUND(3000) ,
    SKIER_NOT_VALID(3001) ,
    SUBSCRIPTION_NOT_FOUND(4000) ,
    SUBSCRIPTION_NOT_VALID(4001) ,
    PISTE_NOT_FOUND(9000),
    PISTE_NOT_VALID(9001) ,

    INSTRUCTOR_NOT_FOUND(5000) ,

    INSTRUCTOR_NOT_VALID(5001),
    COURSE_NOT_FOUND(6000) ,
    COURSE_NOT_VALID(6001) ,
    ADDRESS_NOT_FOUND(7000) ,
    REGISTRATION_NOT_VALID(8000) ,
    REGISTRATION_NOT_FOUND(8001) ;


    private int Code ;
    ErrorCode(int code)
    {
        Code=code ;
    }
    public Integer GetCode()
    {
        return Code ;
    }

}
