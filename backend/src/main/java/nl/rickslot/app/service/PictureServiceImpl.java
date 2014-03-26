package nl.rickslot.app.service;

import nl.rickslot.app.model.Picture;
import nl.rickslot.app.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rick Slot
 */
@Service
public class PictureServiceImpl implements PictureService{

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public boolean createPicture(Picture picture, String username){
        picture.setOwnerUsername(username);
        picture.setName(username +  "-" + picture.getName());
        /* Convert file to bytes */
        if(picture.getFile() !=null){
            try {
                picture.setPictureBytes(picture.getFile().getBytes());
                picture.setFile(null);
            } catch (IOException e) {
                return false;
            }
        }
        pictureRepository.savePicture(picture);
        return true;
    }

    @Override
    public Picture findPicture(String name) {
        return pictureRepository.findPicture(name);
    }

    @Override
    public List<String> findAllPictureNamesOfAccount(String username) {
        List<Picture> pictures =  pictureRepository.findAllPicturesOfAccount(username);
        List<String> pictureNames = new ArrayList<>();
        for(Picture picture : pictures){
            String pictureName = picture.getName();
            pictureName = pictureName.replace(username + "-", "");
            pictureNames.add(pictureName);
        }
        return pictureNames;
    }
}
