package uk.me.davidgrew.goaltracker.application.services;

import uk.me.davidgrew.goaltracker.domain.task.Task;

public interface TaskService {

  void createTask(Task task);
}
