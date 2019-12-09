package uk.me.davidgrew.goaltracker.application.respositories;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.domain.task.ActivityRecord;

public interface ActivityRepository {

  List<Activity> getAllActivities();

  Optional<Activity> findActivityByName(String name);

  Optional<Activity> findActivityById(long id);

  List<ActivityRecord> findActivitiesDuringPeriod(Instant periodStart, Instant periodEnd);

  long createActivity(Activity activity);

  Optional<ActivityRecord> getLatestActivityRecord();

  void createActivityRecord(long activityId, ActivityRecord activityRecord);

  void updateActivityRecord(ActivityRecord activityRecord);
}
