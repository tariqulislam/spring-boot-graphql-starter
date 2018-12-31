package com.example.graphqlstarter.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="groups")
@SuppressWarnings("serial")
public class Group implements Serializable{

    @Id
    @Column(name="group_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="group_name")
    @NotEmpty(message= "* Please Provide Group name First")
    private String name;

    @Column(name="group_description")
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy="group", fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Member> members = new HashSet<>();
}