package br.com.joseneto.to_do_list.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "taks")
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "priority")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private boolean completed = false;
    private Integer priority = 0;
}
