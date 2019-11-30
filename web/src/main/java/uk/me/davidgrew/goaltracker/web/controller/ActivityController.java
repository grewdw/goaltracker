package uk.me.davidgrew.goaltracker.web.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.me.davidgrew.goaltracker.application.services.ActivityService;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.web.form.NewActivityForm;

@RestController
public class ActivityController {

  @Autowired
  private ActivityService activityService;

  @PostMapping("/activity/create")
  public ResponseEntity createActivity(@RequestBody NewActivityForm newActivityForm) {
    long id = activityService.createActivity(new Activity(newActivityForm.getName()));
    return ResponseEntity.status(OK).body(id);
  }

  @PostMapping("/activity/{id}/start")
  public ResponseEntity startActivity(@PathVariable long id) {
    activityService.startActivity(id);
    return ResponseEntity.status(OK).build();
  }

  @PostMapping("/activity/stop")
  public ResponseEntity stopActivity() {
    activityService.stopActivity();
    return ResponseEntity.ok().build();
  }
}
