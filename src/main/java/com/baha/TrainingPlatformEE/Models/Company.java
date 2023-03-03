package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "CompanyInfo")
public class Company extends AbstractEntity {
    @Id
    private String Name ;
    private String Description ;
    @Embedded
    private Address Address ;
    private String Photo ;
    private String Email ;
    private String SiteWeb ;
    @OneToMany(mappedBy = "company")
    private List<User> Users ;
}

