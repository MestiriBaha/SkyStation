package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Color;
import com.baha.TrainingPlatformEE.Models.Piste;
import com.baha.TrainingPlatformEE.Models.Skier;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class PisteDTO {

    private Long NumPiste ;
    private String NamePiste ;
    private Color color ;
    private Integer Length ;
    private Integer Slope ;
    private List<SkierDTO> Skiers ;

    public static PisteDTO FromEntity(Piste piste)
    {
        if (piste == null ) { return null ; }
        return PisteDTO.builder()
                .NamePiste(piste.getNamePiste())
                .color(piste.getColor())
                .Length(piste.getLength())
                .Slope(piste.getSlope())
                .NumPiste(piste.getNumPiste())
                .Skiers(
                        piste.getSkiers()
                                .stream()
                                .map(SkierDTO::FromEntity)
                                .collect(Collectors.toList())
                )
                .build() ;
    }

    public static Piste ToEntiy(PisteDTO pistedto)
    {
        if (pistedto == null ) { return null ; }
        return Piste.builder()
                .NumPiste(pistedto.getNumPiste())
                .NamePiste(pistedto.getNamePiste())
                .color(pistedto.getColor())
                .Length(pistedto.getLength())
                .Slope(pistedto.getSlope())
                .Skiers(
                        pistedto.getSkiers() !=null ?
                                pistedto.getSkiers()
                                        .stream()
                                        .map(SkierDTO::ToEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build() ;
    }


}
