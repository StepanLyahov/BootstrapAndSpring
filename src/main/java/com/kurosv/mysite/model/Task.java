package com.kurosv.mysite.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "priority")
    private String priority;

    @Column(name = "description")
    private String description;

    public Task () {}

    public Task(String title, String priority, String description) {
        this.title = title;
        this.priority = priority;
        this.description = description;
    }
}
