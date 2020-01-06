package com.kurosv.mysite.repository;

import com.kurosv.mysite.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepositiry extends JpaRepository<Task, Integer> {
    List<Task> findByTitleLike(String title);
}
