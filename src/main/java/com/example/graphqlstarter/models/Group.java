package com.example.graphqlstarter.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="groups")
public class Group {

    @Id
    @Column(name="group_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="group_name")
    @NotEmpty(message= "* Please Provide Group name First")
    private String name;

    @Column(name="group_description")
    private String description;
}