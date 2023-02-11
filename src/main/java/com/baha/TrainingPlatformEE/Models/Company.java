package com.baha.TrainingPlatformEE.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "CompanyInfo")
public class Company extends AbstractEntity {

    private String Name ;
    private String Description ;
    @Embedded
    private Address Address ;
    private String Photo ;
    private String Email ;
    private String SiteWeb ;
    @OneToMany(mappedBy = "Company")
    private List<User> Users ;
}

