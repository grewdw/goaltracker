package uk.me.davidgrew.goaltracker.application.implementations;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.me.davidgrew.goaltracker.application.respositories.TaskRepository;
import uk.me.davidgrew.goaltracker.application.services.TaskService;
import uk.me.davidgrew.goaltracker.domain.task.Task;
import uk.me.davidgrew.goaltracker.domain.task.TaskRecord;
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

  @Override
  public void addTaskRecord(long taskId, TaskRecord taskRecord) {
    if (taskRepository.taskExists(taskId)) {
      taskRepository.addTaskRecord(taskId, taskRecord);
    } else {
      throw new IllegalArgumentException();
    }
  }

  private boolean containsDuplicateTargets(Task task) {
    return task.getTargets().stream()
      .map(TaskTarget::getPeriod)
      .collect(Collectors.toSet()).size()
      != task.getTargets().size();
  }
}
