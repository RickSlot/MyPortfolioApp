package nl.rickslot.app.service;

import nl.rickslot.app.model.Picture;

import java.util.List;

/**
 * @author Rick Slot
 */
public interface PictureService {
    /**
     * Creates a picture
     * @param picture the picture that needs to be saved
     * @param username the owner username of the picture
     * @return true if saved, false otherwise
     */
    boolean createPicture(Picture picture, String username);

    /**
     * This function finds a picture by its name.
     * @param name the name of the picture with username prefix
     * @return the picture that is found
     */
    Picture findPicture(String name);

    List<String> findAllPictureNamesOfAccount(String username);
}
