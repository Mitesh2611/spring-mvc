package com.in28minutes.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoRestController {
    @Autowired
    TodoService service;

    @RequestMapping(path = "/todos")
    public List<Todo> retrieveAllTodos(){
        return service.retrieveTodos("mitesh");
    }

    @RequestMapping(path = "/todos/{id}")
    public Todo retrieveTodo(@PathVariable int id){
        return service.retrieveTodos(id);
    }
}
