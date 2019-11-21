package uk.me.davidgrew.goaltracker.application.implementations;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.me.davidgrew.goaltracker.application.respositories.TaskRepository;
import uk.me.davidgrew.goaltracker.application.services.TaskService;
import uk.me.davidgrew.goaltracker.domain.task.TargetPeriod;
import uk.me.davidgrew.goaltracker.domain.task.Task;
import uk.me.davidgrew.goaltracker.domain.task.TaskTarget;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Override
  public void createTask(Task task) {
    if (containsDuplicateTargets(task)
        || taskRepository.getTask(task.getName()).isPresent()) {
      throw new IllegalArgumentException();
    }
    taskRepository.createTask(task);
  }

  private boolean containsDuplicateTargets(Task task) {
    Set<TargetPeriod> periods = new HashSet<>();
    for (TaskTarget target : task.getTargets()) {
      if (periods.contains(target.getPeriod())) {
        return true;
      } else {
        periods.add(target.getPeriod());
      }
    }
    return false;
  }
}
