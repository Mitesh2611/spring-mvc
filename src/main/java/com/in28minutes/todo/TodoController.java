package com.in28minutes.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

// handle web request
@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    TodoService service;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }

    private static String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();
        return principal.toString();
    }

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodoList(ModelMap modelMap)
    {
        modelMap.addAttribute("todos", service.retrieveTodos(getLoggedInUserName()));
        return "list-todos";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap modelMap)
    {
//        throw new RuntimeException("Dummy Exception");
        modelMap.addAttribute("todo", new Todo(0, getLoggedInUserName(),"", new Date(), false));
        return "add-todo";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors())
            return "add-todo";

        service.addTodo(getLoggedInUserName(), todo.getDescription(), todo.getTargetDate(), false);
        model.clear();
        return "redirect:list-todos";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam int id)
    {
        service.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(ModelMap model, @RequestParam int id)
    {
        model.addAttribute("todo", service.retrieveTodos(id));
        return "add-todo";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors())
            return "add-todo";

        todo.setUser(getLoggedInUserName());
        service.updateTodo(todo);

        model.clear();// to prevent request parameter "name" to be passed
        return "redirect:/list-todos";
    }


}
