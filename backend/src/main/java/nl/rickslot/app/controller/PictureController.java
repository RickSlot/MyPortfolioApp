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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    /**
     * calls picture service to create a picture. returns the right page afterward
     * @param picture
     * @param redirectAttributes
     * @return redirect to home
     */
    @RequestMapping(value = "/create")
    public String createPicture(Picture picture, RedirectAttributes redirectAttributes){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        pictureService.createPicture(picture, authentication.getName());
        redirectAttributes.addFlashAttribute("message_success", "Image is uploaded!");
        return "redirect:/";
    }

    /**
     * Creates the picture page
     * @return the name of the picture page
     */
    @RequestMapping(value = "/createPage")
    public String createPicturePage(){
        return "createPicture";
    }

    /**
     * returns the page that shows a picture
     * @param name the name of the picture
     * @return the picture bytes
     */
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
