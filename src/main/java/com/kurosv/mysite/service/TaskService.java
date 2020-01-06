package com.kurosv.mysite.service;

import com.kurosv.mysite.model.Task;
import com.kurosv.mysite.repository.TaskRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepositiry taskRepositiry;

    public Task saveTask (String title, String priority, String description) {
        Task task = new Task(title, priority, description);
        taskRepositiry.save(task);
        return task;
    }

    public void deleteByTitle (String title) {
        List<Task> list = taskRepositiry.findByTitleLike(title);
        if (list.size() > 0) {
            taskRepositiry.delete(list.get(0));
        }
    }

    public List<Task> getAllTask () {
        return taskRepositiry.findAll();
    }
}
