package com.todolist.controllers;

import com.todolist.domain.entities.TodoEntity;
import com.todolist.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    List<TodoEntity> create(@RequestBody @Valid TodoEntity todo){
        return todoService.create(todo);
    }

    @PutMapping
    List<TodoEntity> update(@RequestBody TodoEntity todo){
      return   todoService.update(todo);
    }

    @GetMapping
    List<TodoEntity> list(){
       return todoService.list();
    }

    @DeleteMapping("{id}")
    List<TodoEntity> delete(@PathVariable("id") Long id){
       return todoService.delete(id);
    }
}
