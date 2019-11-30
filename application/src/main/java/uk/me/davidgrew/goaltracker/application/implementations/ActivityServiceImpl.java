package uk.me.davidgrew.goaltracker.application.implementations;

import java.time.Instant;
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
  public long createActivity(Activity activity) {
    if (activityRepository.findByName(activity.getName()).isPresent()) {
      throw new IllegalArgumentException();
    } else {
      return activityRepository.createActivity(activity);
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

  @Override
  public void stopActivity() {
    startActivity(activityRepository.findByName(UNRECORDED)
      .map(Activity::getId)
      .orElseGet(() -> createActivity(new Activity(UNRECORDED))));
  }
}
