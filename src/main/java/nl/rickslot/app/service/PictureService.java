package nl.rickslot.app.service;

import nl.rickslot.app.model.Picture;

/**
 * @author Rick Slot
 */
public interface PictureService {
    boolean createPicture(Picture picture, String username);
    Picture findPicture(String name);
}
