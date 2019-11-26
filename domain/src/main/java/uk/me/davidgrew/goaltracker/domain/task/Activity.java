package uk.me.davidgrew.goaltracker.domain.task;

import java.util.List;

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
    this.name = name;
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
