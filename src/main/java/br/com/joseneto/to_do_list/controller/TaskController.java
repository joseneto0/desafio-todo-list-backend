package br.com.joseneto.to_do_list.controller;

import br.com.joseneto.to_do_list.domain.entity.Task;
import br.com.joseneto.to_do_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> viewAll(){
        List<Task> tasks = taskService.findAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> viewTaskById(@PathVariable Long id) throws Exception {
        Optional<Task> task = taskService.findTaskById(id);
        if (task.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(task);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task) throws Exception {
        Task newTask = taskService.updateTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(newTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) throws Exception {
        Optional<Task> task = taskService.findTaskById(id);
        if (task.isPresent()){
            taskService.deleteTask(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/ordered")
    public ResponseEntity<List<Task>> orderedByPriority() {
        List<Task> tasks = taskService.orderedByPriority();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }
}
