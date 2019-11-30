package uk.me.davidgrew.goaltracker.domain.task;

import java.time.Instant;

public class ActivityRecord {

  private long id;
  private Instant start;
  private Instant end;

  public ActivityRecord(long id, Instant start, Instant end) {
    this.id = id;
    this.start = start;
    this.end = end;
  }

  public long getId() {
    return id;
  }

  public Instant getStart() {
    return start;
  }

  public Instant getEnd() {
    return end;
  }

  public ActivityRecord(Instant start, Instant end) {
    this.start = start;
    this.end = end;
  }
}
