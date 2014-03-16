package nl.rickslot.app.service;

import nl.rickslot.app.model.Project;

import java.util.List;
import java.util.Set;

/**
 * @author Rick Slot
 */
public interface ProjectService {

    boolean saveProject(Project project);

    Project findProjectById(String projectId);

    List<Project> findProjectsOfAccount(String username);

    Set<String> findProjectCategoriesOfAccount(String username);
}
