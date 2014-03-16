package nl.rickslot.app.service;

import nl.rickslot.app.model.Project;
import nl.rickslot.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rick Slot
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public boolean saveProject(Project project) {
        project.setId(UUID.randomUUID().toString());
        projectRepository.save(project);
        return true;
    }

    @Override
    public Project findProjectById(String projectId) {
        Project project = projectRepository.findProjectById(projectId);
        if(project != null){
            project.setDescription(project.getDescription().replaceAll("(\r|\n)", "<br>"));
            project.setDescription(convertDescription(project.getDescription()));
        }
        return project;
    }

    @Override
    public List<Project> findProjectsOfAccount(String username){
        return projectRepository.findProjectsOfAccount(username);
    }

    @Override
    public Set<String> findProjectCategoriesOfAccount(String username){
        List<Project> projects = projectRepository.findProjectsOfAccount(username);
        Set<String> categories = new LinkedHashSet<>();

        for(Project project : projects){
            categories.add(project.getCategory());
        }
        return categories;
    }



    private String convertDescription(String description){
        final Pattern pattern = Pattern.compile("<image>(.+?)</image>");
        final Matcher matcher = pattern.matcher(description);
        while(matcher.find()){
            String imageString = "<br><img src='/picture/show/rickslot@live.nl-" + matcher.group(1) +".png' height='200' width='200'><br>";
            description = description.replace("<image>" + matcher.group(1) + "</image>", imageString);
        }
        return description;
    }


}
