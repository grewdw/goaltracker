package uk.me.davidgrew.goaltracker.web.form;

import java.util.List;

public class NewTask {

  private String taskName;
  private List<NewTaskTarget> targets;

  private NewTask() {
    //for Jackson serialisation
  }

  public String getTaskName() {
    return taskName;
  }

  public List<NewTaskTarget> getTargets() {
    return targets;
  }
}
