package uk.me.davidgrew.goaltracker.application.implementations;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import uk.me.davidgrew.goaltracker.application.respositories.ActivityRepository;
import uk.me.davidgrew.goaltracker.application.services.ActivityService;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.domain.task.ActivityRecord;

public class ActivityServiceImpl implements ActivityService {

  @Autowired
  private ActivityRepository activityRepository;

  @Override
  public void createActivity(Activity activity) {
    if (activityRepository.activityExists(activity.getName())) {
      throw new IllegalArgumentException();
    } else {
      activityRepository.createActivity(activity);
    }
  }

  @Override
  public void startActivity(long activityId) {
    Instant now = Instant.now();

    activityRepository.getLatestActivityRecord().ifPresent(latest ->
      activityRepository.updateActivityRecord(
        new ActivityRecord(latest.getId(), latest.getStart(), now)));

    activityRepository.createActivityRecord(activityId, new ActivityRecord(now, null));
  }
}
