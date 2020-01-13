package com.kurosv.mysite.controller;

import com.kurosv.mysite.model.Task;
import com.kurosv.mysite.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ContollerToDoTask {

    @Autowired
    TaskService taskService;

    @GetMapping(value = "/index")
    public String main(Model model) {
        List<Task> listTask = taskService.getAllTask();
        model.addAttribute("tasks", listTask);
        return "index";
    }

    @PostMapping("/index")
    public String createNewTask(@RequestParam String title, @RequestParam String priority, @RequestParam String description, Model model) {

        if(!(title + priority + description).equals(""))
            taskService.saveTask(title, priority, description);

        List<Task> listTask = taskService.getAllTask();

        model.addAttribute("tasks", listTask);
        return "index";
    }

}
