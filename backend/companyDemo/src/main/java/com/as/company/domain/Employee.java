package com.as.company.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

     @Column(name = "email")
    private String email;
    
    @Column(name = "contactNo")
    private long contactNo;

    @Column(name = "total_Experience")
    private long totalExp;

    @Column(name = "current_Ctc")
    private double currentCtc;

    @Column(name = "expected_Ctc")
    private double expectedCtc;

    @Column(name = "skills")
    private String skills;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    
}
