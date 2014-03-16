package nl.rickslot.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rick Slot
 */
@Document(collection = "cvs")
public class Cv {
    String ownerUsername;

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }
}
