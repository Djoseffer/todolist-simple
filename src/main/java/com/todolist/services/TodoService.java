package com.todolist.services;

import com.todolist.domain.entities.TodoEntity;
import com.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> create(TodoEntity todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<TodoEntity> list() {
        Sort sort = Sort.by("prioridade")
                .descending()
                .and(Sort.by("nome")
                        .ascending());
        return todoRepository.findAll(sort);
    }

    public List<TodoEntity> update(TodoEntity todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<TodoEntity> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
