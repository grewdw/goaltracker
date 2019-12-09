package uk.me.davidgrew.goaltracker.application.implementations;

import static java.time.temporal.ChronoUnit.MINUTES;

import com.google.common.base.Preconditions;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.me.davidgrew.goaltracker.application.respositories.ActivityRepository;
import uk.me.davidgrew.goaltracker.application.services.ActivityService;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.domain.task.ActivityRecord;

@Service
public class ActivityServiceImpl implements ActivityService {

  private static final String UNRECORDED = "Unrecorded";

  @Autowired
  private ActivityRepository activityRepository;

  @Override
  public List<Activity> getActivities() {
    return activityRepository.getAllActivities();
  }

  @Override
  public long createActivity(Activity activity) {
    Preconditions.checkArgument(activityRepository.findActivityByName(activity.getName()).isPresent());
    return activityRepository.createActivity(activity);
  }

  @Override
  public void startActivity(long activityId) {
    Instant activityEnd = Instant.now();
    Instant activityStart = activityEnd.plus(1, MINUTES);

    activityRepository.getLatestActivityRecord().ifPresent(latest ->
      activityRepository.updateActivityRecord(
        new ActivityRecord(latest.getId(), latest.getStart(), activityEnd)));

    activityRepository.createActivityRecord(activityId, new ActivityRecord(activityStart, null));
  }

  @Override
  public void stopActivity() {
    startActivity(activityRepository.findActivityByName(UNRECORDED)
      .map(Activity::getId)
      .orElseGet(() -> createActivity(new Activity(UNRECORDED))));
  }

  @Override
  public void insertActivity(long activityId, ActivityRecord activityRecord) {
    Preconditions.checkArgument(activityRepository.findActivityById(activityId).isPresent());

    Instant start = activityRecord.getStart();
    Instant end = activityRecord.getEnd();

      Preconditions.checkArgument(
      activityRepository.findActivitiesDuringPeriod(start, end).isEmpty());

    activityRepository.createActivityRecord(activityId, new ActivityRecord(start, end));
  }
}
