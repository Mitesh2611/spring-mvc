package com.in28minutes.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// handle web request
@Controller
public class WelcomeController {
    // LoginService service = new LoginService();

//    @Autowired
//    private LoginService service;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String displayWelcomePage(ModelMap modelMap)
    {
        modelMap.put("name", "mitesh"); // to display it on welcome page, bcz no POST method
        return "welcome";
    }

   /* @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleUserLogin(@RequestParam String name,
                              @RequestParam String password,
                              ModelMap model)
    {
        if(!service.validateUser(name, password)) {
            model.put("errorMessage", "Invalid Credentials !!!");
            return "login";
        }
        model.put("name", name);
        return "welcome";
    }*/
}
