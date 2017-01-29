package schere.stein.papier.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ilja on 28.01.17.
 */
@Controller
public class IndexController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homepage(){
        return "index.html";
    }
}