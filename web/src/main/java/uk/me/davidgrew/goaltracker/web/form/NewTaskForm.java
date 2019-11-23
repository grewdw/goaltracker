package uk.me.davidgrew.goaltracker.web.form;

import java.util.List;

public class NewTaskForm {

  private String taskName;
  private List<NewTaskTargetForm> targets;

  private NewTaskForm() {
    //for Jackson serialisation
  }

  public String getTaskName() {
    return taskName;
  }

  public List<NewTaskTargetForm> getTargets() {
    return targets;
  }
}
