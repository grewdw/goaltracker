package uk.me.davidgrew.goaltracker.application.respositories;

import java.util.Optional;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.domain.task.ActivityRecord;

public interface ActivityRepository {

  boolean activityExists(String name);

  void createActivity(Activity activity);

  Optional<ActivityRecord> getLatestActivityRecord();

  void createActivityRecord(long activityId, ActivityRecord activityRecord);

  void updateActivityRecord(ActivityRecord activityRecord);
}
