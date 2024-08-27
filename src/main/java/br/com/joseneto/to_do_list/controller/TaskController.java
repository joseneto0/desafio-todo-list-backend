package br.com.joseneto.to_do_list.controller;

import br.com.joseneto.to_do_list.domain.entity.Task;
import br.com.joseneto.to_do_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> viewAll(){
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public Task viewTaskById(@PathVariable Long id) throws Exception {
        return taskService.findTaskById(id);
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task) throws Exception {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteTask(@PathVariable Long id) throws Exception {
        return taskService.deleteTask(id);
    }

    @GetMapping("/ordered")
    public List<Task> orderedByPriority() {
        return taskService.orderedByPriority();
    }
}
