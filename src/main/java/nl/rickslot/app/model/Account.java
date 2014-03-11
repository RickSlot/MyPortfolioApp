package nl.rickslot.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rick Slot
 */
@Document(collection = "accounts")
public class Account {
    @Id
    String username;
    String firstName;
    String lastName;
    String password;
    Byte pictureBytes[];

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte[] getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(Byte[] pictureBytes) {
        this.pictureBytes = pictureBytes;
    }
}
