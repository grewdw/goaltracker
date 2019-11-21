package uk.me.davidgrew.goaltracker.domain.task;

public class TaskTarget {

  private long id;
  private TargetPeriod period;
  private TargetDirection direction;
  private int count;
  private boolean current;

  public TaskTarget(long id, TargetPeriod period,
    TargetDirection direction, int count, boolean current) {
    this(period, direction, count, current);
    this.id = id;
  }

  public TaskTarget(TargetPeriod period,
    TargetDirection direction, int count, boolean current) {

    this.period = period;
    this.direction = direction;
    this.count = count;
    this.current = current;
  }

  public TargetPeriod getPeriod() {
    return period;
  }

  public TargetDirection getDirection() {
    return direction;
  }

  public int getCount() {
    return count;
  }

  public boolean isCurrent() {
    return current;
  }
}
