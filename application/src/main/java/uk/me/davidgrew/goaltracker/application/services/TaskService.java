package uk.me.davidgrew.goaltracker.application.services;

import uk.me.davidgrew.goaltracker.domain.task.Task;
import uk.me.davidgrew.goaltracker.domain.task.TaskRecord;

public interface TaskService {

  void createTask(Task task);

  void addTaskRecord(long taskId, TaskRecord taskRecord);
}
