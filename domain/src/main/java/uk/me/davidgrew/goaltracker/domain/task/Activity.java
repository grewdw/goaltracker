package uk.me.davidgrew.goaltracker.domain.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

public class Activity {

  private long id;
  private String name;
  private List<ActivityRecord> activityRecords;

  public Activity(long id, String name, List<ActivityRecord> activityRecords) {
    this.id = id;
    this.name = name;
    this.activityRecords = activityRecords;
  }

  public Activity(String name) {
    this.name = Arrays.stream(name.toLowerCase().stripLeading().stripTrailing()
      .split(" "))
      .map(StringUtils::capitalize)
      .collect(Collectors.joining(" "));
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<ActivityRecord> getActivityRecords() {
    return activityRecords;
  }
}
