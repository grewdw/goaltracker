package uk.me.davidgrew.goaltracker.web.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.me.davidgrew.goaltracker.application.services.TaskService;
import uk.me.davidgrew.goaltracker.domain.task.Task;
import uk.me.davidgrew.goaltracker.domain.task.TaskRecord;
import uk.me.davidgrew.goaltracker.domain.task.TaskTarget;
import uk.me.davidgrew.goaltracker.web.form.NewTaskForm;
import uk.me.davidgrew.goaltracker.web.form.TaskRecordForm;

@RestController
public class TaskController {

  @Autowired
  private TaskService taskService;

  @PostMapping("/task/create")
  public ResponseEntity createTask(@RequestBody NewTaskForm newTaskForm) {
    List<TaskTarget> targets = newTaskForm.getTargets().stream()
      .map(target -> new TaskTarget(target.getPeriod(), target.getDirection(), target.getCount(),
        true))
      .collect(Collectors.toList());
    taskService.createTask(new Task(newTaskForm.getTaskName(), targets));
    return ResponseEntity.status(OK).build();
  }

  @PostMapping("/task/{id}/record")
  public ResponseEntity recordTask(@PathVariable int id,
    @RequestBody TaskRecordForm taskRecordForm) {
    taskService
      .addTaskRecord(id, new TaskRecord(taskRecordForm.getCount(), taskRecordForm.getTime()));
    return ResponseEntity.status(OK).build();
  }
}
