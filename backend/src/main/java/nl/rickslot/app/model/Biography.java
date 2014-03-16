package nl.rickslot.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rick Slot
 */
@Document(collection = "biographies")
public class Biography {
    //unique id
    String ownerUsername;
    String id;
    String text;
    Byte pictureBytes[];

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Byte[] getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(Byte[] pictureBytes) {
        this.pictureBytes = pictureBytes;
    }
}
