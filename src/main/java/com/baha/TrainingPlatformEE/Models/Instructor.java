package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Table(name = "Instructors")
public class Instructor extends AbstractEntity{
    private Long NumInstructor ;
    private  String firstName ;
    private String lastName ;
    private Date DateOfHire ;

    //@OneToMany(mappedBy = "instructor")
    @OneToMany
    private List<Course> Courses ;


}
