package com.cmepps.listatareas.application;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cmepps.listatareas.core.domain.Todo;
import com.cmepps.listatareas.core.driven_ports.TodoRepository;
import com.cmepps.listatareas.core.driver_ports.ITodoService;

@Service
public class TodoService implements ITodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodosByUser(String user) {
        return todoRepository.findByUserName(user);
    }

    @Override
    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(
            String name,
            String desc,
            Date targetDate,
            boolean isDone) {

        todoRepository.save(
                new Todo(name, desc, targetDate, isDone));
    }

    @Override
    public void deleteTodo(Long id) {

        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
        }
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }
}