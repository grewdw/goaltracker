package uk.me.davidgrew.goaltracker.domain.task;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class ActivityRecord {

  private long id;
  private Instant start;
  private Instant end;

  public ActivityRecord(Instant start, Instant end) {
    this.start = Optional.ofNullable(start)
      .map(e -> e.truncatedTo(ChronoUnit.MINUTES)).orElse(null);
    this.end = Optional.ofNullable(end)
      .map(e -> e.truncatedTo(ChronoUnit.MINUTES)).orElse(null);
  }

  public ActivityRecord(long id, Instant start, Instant end) {
    this(start, end);
    this.id = id;
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
}
