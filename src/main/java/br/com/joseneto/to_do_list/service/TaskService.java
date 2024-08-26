package br.com.joseneto.to_do_list.service;

import br.com.joseneto.to_do_list.domain.entity.Task;
import br.com.joseneto.to_do_list.domain.repository.TaskRepository;
import br.com.joseneto.to_do_list.service.comparator.TaskComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        if (task.getPriority() == null){
            task.setPriority(0);
        }
        this.taskRepository.save(task);
        return task;
    }

    public Task findTaskById(Long id) throws Exception {
        return this.taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found"));
    }

    public List<Task> findAllTasks() {
        return this.taskRepository.findAll();
    }

    public Task updateTask(Long id, Task task) throws Exception {
        Task newTask = this.taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found"));
        newTask.setName(task.getName());
        newTask.setDescription(task.getDescription());
        newTask.setCompleted(task.isCompleted());
        newTask.setPriority(task.getPriority());
        this.taskRepository.save(newTask);
        return newTask;
    }

    public HttpStatus deleteTask(Long id) throws Exception {
        Task newTask = this.taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found"));
        this.taskRepository.delete(newTask);
        return HttpStatus.OK;
    }

    public List<Task> orderedByPriority(){
        List<Task> tasks = this.taskRepository.findAll();
        tasks.sort(new TaskComparator());
        return tasks;
    }

    public Task completeTask(Long id) throws Exception {
        Task newTask = this.taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found"));
        newTask.setCompleted(true);
        this.taskRepository.save(newTask);
        return newTask;
    }






}
