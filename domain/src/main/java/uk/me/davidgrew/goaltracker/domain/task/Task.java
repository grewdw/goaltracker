package uk.me.davidgrew.goaltracker.domain.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

public class Task {

  private long id;
  private String name;
  private List<TaskTarget> targets;

  public Task(long id, String name, List<TaskTarget> targets) {
    this(name, targets);
    this.id = id;
  }

  public Task(String name, List<TaskTarget> targets) {
    this.name = Arrays.stream(name.stripLeading().stripTrailing().toLowerCase().split(" "))
      .map(StringUtils::capitalize)
      .collect(Collectors.joining(" "));
    this.targets = targets;
  }

  public String getName() {
    return name;
  }

  public List<TaskTarget> getTargets() {
    return targets;
  }
}
