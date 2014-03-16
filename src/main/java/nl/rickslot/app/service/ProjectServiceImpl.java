package nl.rickslot.app.service;

import nl.rickslot.app.model.Project;
import nl.rickslot.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

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
        if(project.getPictureFile() !=null){
            try {
                project.setImageBytes(project.getPictureFile().getBytes());
                project.setPictureFile(null);
            } catch (IOException e) {
                return false;
            }
        }
        projectRepository.save(project);
        return true;
    }
}
