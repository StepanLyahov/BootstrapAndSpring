package com.kurosv.mysite.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    private String title;
    private String priority;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "task_comment",
            joinColumns = @JoinColumn(name = "task_fk"),
            inverseJoinColumns = @JoinColumn(name = "comment_fk"))
    private List<Comment> comments;

    @ManyToOne(targetEntity = Term.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "term_id")
    private Term term;
}
