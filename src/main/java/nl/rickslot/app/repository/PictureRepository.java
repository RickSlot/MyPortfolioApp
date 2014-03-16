package nl.rickslot.app.repository;

import nl.rickslot.app.model.Picture;
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
public class PictureRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Bean
    public PictureRepository PictureRepository(){
        return new PictureRepository();
    }

    public void savePicture(Picture picture){
        mongoTemplate.save(picture);
    }

    public Picture findPicture(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Picture.class);
    }
}
