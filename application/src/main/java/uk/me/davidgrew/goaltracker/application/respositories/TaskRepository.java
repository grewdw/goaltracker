package uk.me.davidgrew.goaltracker.application.respositories;

import java.util.Optional;
import uk.me.davidgrew.goaltracker.domain.task.Task;
import uk.me.davidgrew.goaltracker.domain.task.TaskRecord;

public interface TaskRepository {

  Optional<Task> getTask(String name);

  boolean taskExists(long id);

  void createTask(Task task);

  void addTaskRecord(long taskId, TaskRecord record);
}
