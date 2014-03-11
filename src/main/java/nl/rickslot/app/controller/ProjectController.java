package nl.rickslot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping(value = "/createPage")
    public String createProjectPage(RedirectAttributes attributes){
        return "createProject";
    }
}
