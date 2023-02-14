package com.baha.TrainingPlatformEE.Exceptions;

public enum ErrorCode {
    COMPANY_NOT_FOUND(1000),
    USER_NOT_FOUND(2000),
    SKIER_NOT_FOUND(3000) ,
    SUBSCRIPTION_NOT_FOUND(4000) ,
    INSTRUCTOR_NOT_FOUND(5000) ,
    COURSE_NOT_FOUND(6000) ,
    ADDRESS_NOT_FOUND(7000) ;


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
