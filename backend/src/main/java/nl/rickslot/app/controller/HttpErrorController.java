package nl.rickslot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/error")
public class HttpErrorController {

    /**
     * shows a 404 not found page
     * @return pagenotfound page.
     */
    @RequestMapping(value = "/404")
    public String error404(){
        return "pageNotFound";
    }
}
