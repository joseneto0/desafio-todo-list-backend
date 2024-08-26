package br.com.joseneto.to_do_list.service.comparator;

import br.com.joseneto.to_do_list.domain.entity.Task;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        return Integer.compare(task1.getPriority(), task2.getPriority());
    }
}
