package uk.me.davidgrew.goaltracker.domain.task;

import java.util.List;

public class Task {

  private long id;
  private String name;
  private List<TaskTarget> targets;

  public Task(long id, String name, List<TaskTarget> targets) {
    this(name, targets);
    this.id = id;
  }

  public Task(String name, List<TaskTarget> targets) {
    this.name = name;
    this.targets = targets;
  }

  public String getName() {
    return name;
  }

  public List<TaskTarget> getTargets() {
    return targets;
  }
}
