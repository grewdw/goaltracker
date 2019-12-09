package uk.me.davidgrew.goaltracker.application.services;

import java.util.List;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.domain.task.ActivityRecord;

public interface ActivityService {

  List<Activity> getActivities();

  long createActivity(Activity activity);

  void startActivity(long activityId);

  void stopActivity();

  void insertActivity(long activityId, ActivityRecord activityRecord);
}
