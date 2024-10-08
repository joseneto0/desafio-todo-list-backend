package br.com.joseneto.to_do_list.service;

import br.com.joseneto.to_do_list.domain.entity.Task;
import br.com.joseneto.to_do_list.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        this.taskRepository.save(task);
        return task;
    }

    public Optional<Task> findTaskById(Long id) throws Exception {
        return this.taskRepository.findById(id);
    }

    public List<Task> findAllTasks() {
        return this.taskRepository.findAll();
    }

    public Task updateTask(Task task) throws Exception {
        this.taskRepository.save(task);
        return task;
    }

    public void deleteTask(Long id) throws Exception {
        this.taskRepository.deleteById(id);
    }

    public List<Task> orderedByPriority(){
        Sort listSorted = Sort.by("priority").descending();
        return this.taskRepository.findAll(listSorted);
    }
}
