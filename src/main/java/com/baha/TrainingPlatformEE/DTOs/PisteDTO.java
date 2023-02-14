package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Color;
import com.baha.TrainingPlatformEE.Models.Piste;
import com.baha.TrainingPlatformEE.Models.Skier;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PisteDTO {
    private Integer ID  ;

    private Long NumPiste ;
    private String NamePiste ;
    private Color color ;
    private Integer Length ;
    private Integer Slope ;
    private List<SkierDTO> Skiers ;

    public PisteDTO FromEntity(Piste piste)
    {
        if (piste == null ) { return null ; }
        return PisteDTO.builder()
                .ID(piste.getID())
                .NamePiste(piste.getNamePiste())
                .color(piste.getColor())
                .Length(piste.getLength())
                .Slope(piste.getSlope())
                .NumPiste(piste.getNumPiste())
                //.skier
                .build() ;
    }

    public Piste ToEntiy(PisteDTO pistedto)
    {
        if (pistedto == null ) { return null ; }
        Piste piste =  new Piste() ;
        piste.setNamePiste(pistedto.getNamePiste());
        piste.setNumPiste(pistedto.getNumPiste());
        piste.setSlope(pistedto.getSlope());
        piste.setLength(pistedto.getLength());
        piste.setColor(pistedto.getColor());
        piste.setID(pistedto.getID());
        //skiers


        return piste ;
    }


}
