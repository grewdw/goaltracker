package uk.me.davidgrew.goaltracker.persistence.transformer;

import org.springframework.stereotype.Component;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityEntity;

@Component
public class ActivityTransformer {

  public Activity fromEntity(ActivityEntity entity) {
    return new Activity(entity.getId(), entity.getName());
  }
}
