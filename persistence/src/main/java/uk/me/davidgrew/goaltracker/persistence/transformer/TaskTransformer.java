package uk.me.davidgrew.goaltracker.persistence.transformer;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import uk.me.davidgrew.goaltracker.domain.task.Task;
import uk.me.davidgrew.goaltracker.domain.task.TaskTarget;
import uk.me.davidgrew.goaltracker.persistence.entity.TaskEntity;
import uk.me.davidgrew.goaltracker.persistence.entity.TaskTargetEntity;

@Component
public class TaskTransformer {

  public Task fromEntity(TaskEntity task) {
    List<TaskTarget> targets = task.getTargets().stream()
      .map(e -> new TaskTarget(e.getId(), e.getPeriod(), e.getDirection(), e.getCount(),
        e.isCurrent()))
      .collect(Collectors.toList());
    return new Task(task.getId(), task.getName(), targets);
  }

  public TaskEntity toNewEntity(Task task) {
    List<TaskTargetEntity> targets = task.getTargets().stream()
      .map(
        dto -> new TaskTargetEntity(dto.getPeriod(), dto.getDirection(), dto.getCount(),
          dto.isCurrent()))
      .collect(Collectors.toList());
    return new TaskEntity(task.getName(), targets);
  }
}
