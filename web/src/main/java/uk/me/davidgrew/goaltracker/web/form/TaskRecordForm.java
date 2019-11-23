package uk.me.davidgrew.goaltracker.web.form;

import java.time.Instant;

public class TaskRecordForm {

  private int count;
  private Instant time;

  private TaskRecordForm() {
    //for Jackson serialisation
  }

  public int getCount() {
    return count;
  }

  public Instant getTime() {
    return time;
  }
}
