package com.kurosv.mysite.controller;

import com.kurosv.mysite.model.Task;
import com.kurosv.mysite.service.ProjectService;
import com.kurosv.mysite.service.TaskService;
import com.kurosv.mysite.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class ContollerToDoTask {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TermService termService;
    @Autowired
    private ProjectService projectService;


    @GetMapping(value = "/index")
    public String main(Model model) {
        List<Task> listTask = taskService.getAllTask();
        model.addAttribute("tasks", listTask);
        return "index";
    }

    @PostMapping("/index")
    public String createNewTask(@RequestParam String title,
                                @RequestParam String priority,
                                @RequestParam String description,
                                @RequestParam String date_start,
                                @RequestParam String date_end,
                                @RequestParam String id_project,
                                Model model) {

        if(!(title + priority + description).equals("")) {
            Task task = taskService.saveTask(title, priority, description, termService.createTerm(date_start, date_end));
            try {
                Integer id = Integer.parseInt(id_project);
                projectService.addTaskToProject(id, task);
            } catch (Exception e) { }
        }

        List<Task> listTask = taskService.getAllTask();

        model.addAttribute("tasks", listTask);
        return "index";
    }
}
