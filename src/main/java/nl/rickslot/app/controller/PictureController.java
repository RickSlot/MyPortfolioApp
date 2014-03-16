package nl.rickslot.app.controller;

import nl.rickslot.app.model.Picture;
import nl.rickslot.app.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @RequestMapping(value = "/create")
    public String createPicture(Picture picture){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        pictureService.createPicture(picture, authentication.getName());
        return "redirect:/";
    }

    @RequestMapping(value = "/createPage")
    public String createPicturePage(){
        return "createPicture";
    }

    @RequestMapping(value = "/show/{name:.+.}.png")
    @ResponseBody
    public byte[] showPicture(@PathVariable("name") String name){
        Picture picture = pictureService.findPicture(name);
        if(picture != null){
            return picture.getPictureBytes();
        }
        return null;
    }
}
