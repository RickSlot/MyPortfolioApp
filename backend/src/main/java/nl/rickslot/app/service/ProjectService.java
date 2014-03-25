package nl.rickslot.app.service;

import nl.rickslot.app.model.Project;

import java.util.List;
import java.util.Set;

/**
 * @author Rick Slot
 */
public interface ProjectService {

    /**
     * Saves a project
     * @param project
     * @return true if saved, false if not
     */
    boolean saveProject(Project project);

    /**
     * finds a project by its id and converts it to be shown
     * @param projectId
     * @return the project that is found
     */
    Project findProjectByIdAndConvert(String projectId);

    /**
     * Find all projects of an account
     * @param username the username of the account
     * @return a list of projects
     */

    List<Project> findProjectsOfAccount(String username);

    /**
     * Finds all project categories of an account
     * @param username the username of the account
     * @return a set of categories as strings
     */
    Set<String> findProjectCategoriesOfAccount(String username);

    /**
     * finds a project by its id
     * @param projectId
     * @return the project that is found
     */
    Project findProjectById(String projectId);

    /**
     * updates a project
     * @param project
     * @return true if updated, false if not
     */
    boolean updateProject(Project project);
}
