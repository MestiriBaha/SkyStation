package com.baha.TrainingPlatformEE.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pistes")
public class Piste extends AbstractEntity{
    private Long NumPiste ;
    private String NamePiste ;
    private Color color ;
    private Integer Length ;
    private Integer Slope ;
    @ManyToMany
    private List<Skier> Skiers ;

}
