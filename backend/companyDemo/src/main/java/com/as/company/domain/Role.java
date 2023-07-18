package com.as.company.domain;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    private long roleId;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "experience")
    private long experience;
    
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "role", cascade=CascadeType.ALL)
    private List<Employee> employees=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Dept_Id", nullable = false)
    private Department department;


    
    
}
