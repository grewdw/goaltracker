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
import uk.me.davidgrew.goaltracker.domain.task.TaskTarget;
import uk.me.davidgrew.goaltracker.web.form.NewTask;
import uk.me.davidgrew.goaltracker.web.form.TaskRecord;

@RestController
public class TaskController {

  @Autowired
  private TaskService taskService;

  @PostMapping("/task/create")
  public ResponseEntity createTask(@RequestBody NewTask newTask) {
    List<TaskTarget> targets = newTask.getTargets().stream()
      .map(target -> new TaskTarget(target.getPeriod(), target.getDirection(), target.getCount(),
        true))
      .collect(Collectors.toList());
    taskService.createTask(new Task(newTask.getTaskName(), targets));
    return ResponseEntity.status(OK).build();
  }

  @PostMapping("/task/record/{id}")
  public void recordTask(@PathVariable int id,
    @RequestBody TaskRecord taskRecord) {
    System.out.println(id);
    System.out.println(taskRecord.getCount());
    System.out.println(taskRecord.getRecordInstant());
  }
}
