package br.com.joseneto.to_do_list.domain.repository;

import br.com.joseneto.to_do_list.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
