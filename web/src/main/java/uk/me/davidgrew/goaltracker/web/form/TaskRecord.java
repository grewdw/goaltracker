package uk.me.davidgrew.goaltracker.web.form;

import java.time.Instant;

public class TaskRecord {

  private int count;
  private Instant recordInstant;

  private TaskRecord() {
    //for Jackson serialisation
  }

  public int getCount() {
    return count;
  }

  public Instant getRecordInstant() {
    return recordInstant;
  }
}
