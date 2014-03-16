package nl.rickslot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rick Slot
 */
@Controller
@RequestMapping("/error")
public class HttpErrorController {

    @RequestMapping(value = "/404")
    public String error404(){
        return "pageNotFound";
    }
}
