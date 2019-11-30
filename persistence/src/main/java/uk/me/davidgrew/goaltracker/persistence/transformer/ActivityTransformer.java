package uk.me.davidgrew.goaltracker.persistence.transformer;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.domain.task.ActivityRecord;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityEntity;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityRecordEntity;

@Component
public class ActivityTransformer {

  public Activity fromEntity(ActivityEntity entity) {
    List<ActivityRecord> records = entity.getActivityRecords().stream()
      .map(e -> new ActivityRecord(e.getId(), e.getStart(), e.getEnd()))
      .collect(Collectors.toList());
    return new Activity(entity.getId(), entity.getName(), records);
  }
}
