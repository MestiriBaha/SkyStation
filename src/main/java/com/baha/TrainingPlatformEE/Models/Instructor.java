package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Table(name = "Instructors")
public class Instructor extends AbstractEntity{
    @Id
    private Long NumInstructor ;
    private  String firstName ;
    private String lastName ;
    @Temporal(TemporalType.DATE)
    private Date DateOfHire ;

    //@OneToMany(mappedBy = "instructor")
    @OneToMany
    private List<Course> Courses ;


}
