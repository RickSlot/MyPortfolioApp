package nl.rickslot.app.controller;

import nl.rickslot.app.model.Project;
import nl.rickslot.app.service.PictureService;
import nl.rickslot.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    PictureService pictureService;

    /**
     * Shows the create project page
     * @return the create project page
     */
    @RequestMapping(value = "/createPage")
    public String createProjectPage(){
        return "createProject";
    }

    /**
     * Returns the update page for a project
     * @param projectId the id of the project that needs to be updated
     * @return the update page or 404 if the project is not found
     */
    @RequestMapping(value = "/updatePage/{projectId:.+.}")
    public ModelAndView updateProjectPage(@PathVariable("projectId") String projectId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Project project = projectService.findProjectById(projectId);
        ModelAndView view = new ModelAndView();
        if(project.getOwnerUsername().equals(auth.getName())){
            if(project != null){
                view.addObject("project", project);
                view.addObject("imageTags", pictureService.findAllPictureNamesOfAccount(project.getOwnerUsername()));
                view.setViewName("updateProject");
                return view;
            }
        }
        view.setViewName("/error/404");
        return view;
    }

    /**
     * Calls projectservice to create a project.
     * @param attributes used to redirect after the save
     * @param project the project that needs to be saved
     * @return redirect to home if created, otherwise an error message.
     */
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

    /**
     * call projectservice to update a project
     * @param attributes  used to redirect after the update
     * @param project the project that needs to be updated
     * @return the project page or an error message.
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateProject(RedirectAttributes attributes, Project project){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView view = new ModelAndView();
        if(projectService.updateProject(project)){
            attributes.addFlashAttribute("message_success", "Project updated succesfully!");
            view.setViewName("redirect:/project/show/"+ project.getOwnerUsername() + "/" +  project.getName());
            return view;
        }
        attributes.addFlashAttribute("message_error", "Something went wrong with updating the project.");
        view.setViewName("redirect:/project/updatePage");
        return view;
    }

    /**
     * Show the page of a project
     * @param projectId the project that needs to be shown
     * @return the page of the project or a 404 page
     */
    @RequestMapping(value = "/show/{username:.+.}/{projectId}")
    public ModelAndView showProject(@PathVariable("projectId") String projectId, @PathVariable("username") String username){
        ModelAndView view = new ModelAndView();
        Project project = projectService.findProjectByIdAndConvert(username + "-" + projectId);
        if(project != null){
            view.addObject("project", project);
            view.setViewName("project");
            return view;
        }
        view.setViewName("/error/404");
        return view;
    }
}
