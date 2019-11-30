package uk.me.davidgrew.goaltracker.application.services;

import org.springframework.stereotype.Service;
import uk.me.davidgrew.goaltracker.domain.task.Activity;

public interface ActivityService {

  long createActivity(Activity activity);

  void startActivity(long activityId);

  void stopActivity();
}
