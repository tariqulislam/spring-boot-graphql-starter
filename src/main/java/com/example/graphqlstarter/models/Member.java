package com.example.graphqlstarter.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name= "members")
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="member_id")
    private int id;

    @Column(name="first_name")
    @NotEmpty(message="* Please Enter First Name")
    private String firstName;

    @Column(name="last_name")
    @NotEmpty(message="* Please Enter Last Name")
    private String lastName;

    @Email(message="* Please Enter Valid Email Address")
    @NotEmpty(message=" * Please Provide Email Address")
    @Column(name="email")
    private String email;

    @Column(name="password")
    @NotEmpty(message="* Please Enter Password")
    @Length(min=5, message=" * Password Must be greater than five")
    private String password;

    @ManyToOne(fetch= FetchType.LAZY, optional=false)
    @JoinColumn(name="group_id", nullable= false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Group group;

}