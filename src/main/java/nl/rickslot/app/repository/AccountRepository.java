package nl.rickslot.app.repository;

import nl.rickslot.app.model.Account;
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
public class AccountRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Bean
    public AccountRepository AccountRepository() {
        return new AccountRepository();
    }

    public void save(Account account){
        mongoTemplate.save(account, "accounts");
    }


    public boolean accountExists(String username){
        Query query = new Query(Criteria.where("username").is(username));
        Account account = mongoTemplate.findOne(query, Account.class);
        if(account != null){
            return true;
        }
        return false;
    }

}
