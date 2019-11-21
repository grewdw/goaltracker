package uk.me.davidgrew.goaltracker.application.respositories;

import java.util.Optional;
import uk.me.davidgrew.goaltracker.domain.task.Task;

public interface TaskRepository {

  Optional<Task> getTask(String name);

  void createTask(Task task);
}
