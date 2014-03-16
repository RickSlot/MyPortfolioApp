package nl.rickslot.app.repository;

import nl.rickslot.app.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

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

    public void save(Project project) {
        mongoTemplate.save(project, "projects");
    }


    public Project findProjectById(String projectId) {
        Query query = new Query(Criteria.where("id").is(projectId));
        return mongoTemplate.findOne(query, Project.class);
    }
}
