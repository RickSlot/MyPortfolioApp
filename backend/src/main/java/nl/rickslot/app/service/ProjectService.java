package nl.rickslot.app.service;

import nl.rickslot.app.model.Project;

/**
 * @author Rick Slot
 */
public interface ProjectService {

    boolean saveProject(Project project);

    Project findProjectById(String projectId);
}
