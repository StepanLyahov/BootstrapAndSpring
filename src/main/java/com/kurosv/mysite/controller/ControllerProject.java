package com.kurosv.mysite.controller;

import com.kurosv.mysite.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerProject {
    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/project")
    public String getMainPage(Model model) {
        model.addAttribute("projects", projectService.getAllProject());
        return "project";
    }

    @PostMapping(value = "/project")
    public String createProject(@RequestParam String title_project, @RequestParam String name_user, Model model) {
        projectService.createProject(title_project, name_user);
        model.addAttribute("projects", projectService.getAllProject());
        return "project";
    }
}
