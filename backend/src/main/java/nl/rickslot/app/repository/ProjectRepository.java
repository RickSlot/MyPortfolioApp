package nl.rickslot.app.repository;

import nl.rickslot.app.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rick Slot
 */
@Component
public class ProjectRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Bean
    public ProjectRepository ProjectRepository() {
        return new ProjectRepository();
    }

    /**
     * saves a project
     * @param project the project to be saved
     */
    public void save(Project project) {
        mongoTemplate.save(project, "projects");
    }

    /**
     * finds a project by its id
     * @param projectId the id of the project
     * @return the project that is found
     */
    public Project findProjectById(String projectId) {
        Query query = new Query(Criteria.where("id").is(projectId));
        return mongoTemplate.findOne(query, Project.class);
    }

    /**
     * Finds all projects of an account
     * @param username the username of the account
     * @return a list of all the projects
     */
    public List<Project> findProjectsOfAccount(String username) {
        Criteria criteria = new Criteria().orOperator(Criteria.where("collaboratorUsernames").is(username),
                                                       Criteria.where("ownerUsername").is(username));
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Project.class);
    }


}
