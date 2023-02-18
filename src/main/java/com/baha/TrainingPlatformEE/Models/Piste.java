package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
    @JoinTable(name = "SkierPiste" , joinColumns = @JoinColumn(name = "skier_id") , inverseJoinColumns = @JoinColumn(name = "PisteID"))
    private List<Skier> Skiers ;

}
