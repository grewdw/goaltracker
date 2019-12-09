package uk.me.davidgrew.goaltracker.web.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.me.davidgrew.goaltracker.application.services.ActivityService;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.domain.task.ActivityRecord;
import uk.me.davidgrew.goaltracker.web.form.ActivityRecordForm;
import uk.me.davidgrew.goaltracker.web.form.NewActivityForm;

@RequestMapping("activities/")
@RestController
public class ActivityController {

  @Autowired
  private ActivityService activityService;

  @GetMapping()
  public List<Activity> getActivities() {
    return activityService.getActivities();
  }

  @PostMapping("create")
  public ResponseEntity createActivity(@RequestBody NewActivityForm newActivityForm) {
    long id = activityService.createActivity(new Activity(newActivityForm.getName()));
    return ResponseEntity.status(OK).body(id);
  }

  @PostMapping("{id}/start")
  public ResponseEntity startActivity(@PathVariable long id) {
    activityService.startActivity(id);
    return ResponseEntity.status(OK).build();
  }

  @PostMapping("stop")
  public ResponseEntity stopActivity() {
    activityService.stopActivity();
    return ResponseEntity.ok().build();
  }

  @PostMapping("{id}/insert")
  public ResponseEntity insertActivity(@PathVariable long id,
    @RequestBody ActivityRecordForm newRecord) {
    activityService.insertActivity(id,
      new ActivityRecord(newRecord.getStart().toInstant(), newRecord.getEnd().toInstant()));
    return ResponseEntity.ok().build();
  }
}
