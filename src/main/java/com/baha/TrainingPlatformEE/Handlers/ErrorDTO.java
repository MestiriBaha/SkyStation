package com.baha.TrainingPlatformEE.Handlers;

import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ErrorDTO {
    private Integer HttpCode ;
    private String Message ;
    private ErrorCode errorcode ;
    private List<String> errors = new ArrayList<>() ;

}
