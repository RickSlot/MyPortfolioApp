package nl.rickslot.app.controller;

import nl.rickslot.app.model.Project;
import nl.rickslot.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/createPage")
    public String createProjectPage(){
        return "createProject";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createProject(RedirectAttributes attributes, Project project){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        project.setOwnerUsername(auth.getName());
        ModelAndView view = new ModelAndView();
        if(projectService.saveProject(project)){
            attributes.addFlashAttribute("message_success", "Project created succesfully!");
            view.setViewName("redirect:/");
            return view;
        }
        attributes.addFlashAttribute("message_error", "Something went wrong with creating the project.");
        view.setViewName("redirect:/project/createPage");
        return view;
    }
}
