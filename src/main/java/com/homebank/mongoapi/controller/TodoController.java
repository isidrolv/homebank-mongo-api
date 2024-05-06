package com.homebank.mongoapi.controller;

import com.homebank.mongoapi.model.TodoDTO;
import com.homebank.mongoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TodoDTO>> gellAllTodos() {

        return ResponseEntity.ok(todoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable String id) {
        return ResponseEntity.ok(todoRepository.findById(id).get());
    }

    @PostMapping("/create")
    public ResponseEntity<TodoDTO> createTodo(@RequestBody TodoDTO todo) {
        todo.setFechaCreacion(LocalDateTime.now());
        return ResponseEntity.ok(todoRepository.save(todo));
    }

    @PutMapping("/update")
    public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todo) {
        todo.setFechaActualizacion(LocalDateTime.now());
        return ResponseEntity.ok(todoRepository.save(todo));
    }

}
