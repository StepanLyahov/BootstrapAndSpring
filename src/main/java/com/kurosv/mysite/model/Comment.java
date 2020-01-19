package com.kurosv.mysite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String fio;
    private String discription;

    public Comment(Long id, String fio, String discription) {
        this.id = id;
        this.fio = fio;
        this.discription = discription;
    }

    public Comment() { }
}
