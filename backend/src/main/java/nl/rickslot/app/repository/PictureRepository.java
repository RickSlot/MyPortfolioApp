package nl.rickslot.app.repository;

import nl.rickslot.app.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * This method saves a picture
     * @param picture
     */
    public void savePicture(Picture picture){
        mongoTemplate.save(picture);
    }

    /**
     * finds a picture
     * @param name the name of the picture
     * @return the picture that is found
     */
    public Picture findPicture(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Picture.class);
    }

    public List<Picture> findAllPicturesOfAccount(String username){
        Query query = new Query(Criteria.where("ownerUsername").is(username));
        return mongoTemplate.find(query, Picture.class);
    }
}
