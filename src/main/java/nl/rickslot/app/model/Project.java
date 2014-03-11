package nl.rickslot.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rick Slot
 */
@Document(collection = "projects")
public class Project {
    String id;
    String ownerUsername;
    String name;
    String company;
    String category;
    List<String> collaboratorUsernames = new ArrayList<>();
    String description;
    String summary;
    List<Byte[]> imagesBytes = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCollaboratorUsernames() {
        return collaboratorUsernames;
    }

    public void setCollaboratorUsernames(List<String> collaboratorUsernames) {
        this.collaboratorUsernames = collaboratorUsernames;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Byte[]> getImagesBytes() {
        return imagesBytes;
    }

    public void setImagesBytes(List<Byte[]> imagesBytes) {
        this.imagesBytes = imagesBytes;
    }
}
