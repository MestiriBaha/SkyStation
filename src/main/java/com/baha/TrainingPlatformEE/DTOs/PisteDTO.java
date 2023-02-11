package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Color;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PisteDTO {
    private Long NumPiste ;
    private String NamePiste ;
    private Color color ;
    private Integer Length ;
    private Integer Slope ;

}
