package uk.me.davidgrew.goaltracker.domain.task;

import java.time.Instant;

public class TaskRecord {

  private int count;
  private Instant time;

  public TaskRecord(int count, Instant time) {
    this.count = count;
    this.time = time;
  }

  public int getCount() {
    return count;
  }

  public Instant getTime() {
    return time;
  }
}
