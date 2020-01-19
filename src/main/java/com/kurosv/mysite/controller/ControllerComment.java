package com.kurosv.mysite.controller;

import com.kurosv.mysite.model.Comment;
import com.kurosv.mysite.model.Task;
import com.kurosv.mysite.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerComment {

    @Autowired
    private TaskService taskService;

    private Integer curentIdTask;

    @PostMapping("/comments")
    public String comentTaskPage(@RequestParam String id_task, Model model) {
        Integer id_t = -1;
        try {
            id_t = Integer.parseInt(id_task);

            Task task = taskService.getById(id_t);
            if (task != null) {
                curentIdTask = id_t;
                model.addAttribute("task", task);
                model.addAttribute("comments", task.getComments());
            } else {
                curentIdTask = -1;
            }
        } catch (Exception e) {
            curentIdTask = -1;
        }
        return "comments";
    }


    @PostMapping("/commentss")
    public String comentingTask(@RequestParam String fio,
                                @RequestParam String comment,
                                Model model) {

        if (curentIdTask != -1) {
            Task task = taskService.getById(curentIdTask);
            taskService.deleteByTitle(task.getTitle());

            Comment comment1 = new Comment();
            comment1.setFio(fio);
            comment1.setDiscription(comment);

            task.getComments().add(comment1);

            taskService.saveTask(task);

            model.addAttribute("task", task);
            model.addAttribute("comments", task.getComments());

        }
        return "comments";
    }

}
