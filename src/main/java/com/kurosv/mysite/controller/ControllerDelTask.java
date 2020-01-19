package com.kurosv.mysite.controller;

import com.kurosv.mysite.model.Task;
import com.kurosv.mysite.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerDelTask {
    @Autowired
    TaskService taskService;

    @GetMapping("/del")
    public String delete(Model model) {
        List<Task> listTask = taskService.getAllTask();

        model.addAttribute("tasks", listTask);
        return "del";
    }

    @PostMapping("/del")
    public String delTask (@RequestParam String titleForDel, Model model) {
        taskService.deleteByTitle(titleForDel);
        List<Task> listTask = taskService.getAllTask();
        model.addAttribute("tasks", listTask);
        return "del";
    }
}
