package com.kurosv.mysite.service;

import com.kurosv.mysite.model.Project;
import com.kurosv.mysite.model.Task;
import com.kurosv.mysite.repository.ProjectRepository;
import com.kurosv.mysite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public void createProject(String title_project, String name_user) {

        Project project =  new Project();
        project.setTitle(title_project);
        project.setUser(userRepository.findByUsername(name_user));

        projectRepository.save(project);
    }

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }


    public void addTaskToProject(Integer project_id, Task task) {
        Project project = projectRepository.getOne(project_id);
        if (project != null) {
            projectRepository.delete(project);

            project.getTasks().add(task);

            projectRepository.save(project);
        }
    }

}
