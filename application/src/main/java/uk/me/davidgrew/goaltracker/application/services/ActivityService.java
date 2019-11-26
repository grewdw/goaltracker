package uk.me.davidgrew.goaltracker.application.services;

import uk.me.davidgrew.goaltracker.domain.task.Activity;

public interface ActivityService {

  void createActivity(Activity activity);

  void startActivity(long activityId);
}
