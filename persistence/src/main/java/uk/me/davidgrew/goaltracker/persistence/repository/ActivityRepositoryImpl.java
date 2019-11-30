package uk.me.davidgrew.goaltracker.persistence.repository;

import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.me.davidgrew.goaltracker.application.respositories.ActivityRepository;
import uk.me.davidgrew.goaltracker.domain.task.Activity;
import uk.me.davidgrew.goaltracker.domain.task.ActivityRecord;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityEntity;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityRecordEntity;
import uk.me.davidgrew.goaltracker.persistence.jparepository.ActivityJpaRepository;
import uk.me.davidgrew.goaltracker.persistence.jparepository.ActivityRecordJpaRepository;
import uk.me.davidgrew.goaltracker.persistence.transformer.ActivityTransformer;

@Repository
public class ActivityRepositoryImpl implements ActivityRepository {

  @Autowired
  private ActivityJpaRepository activityJpaRepository;

  @Autowired
  private ActivityRecordJpaRepository activityRecordJpaRepository;

  @Autowired
  private ActivityTransformer activityTransformer;

  @Override
  public Optional<Activity> findByName(String name) {
    return Optional.ofNullable(activityJpaRepository.findByName(name))
      .map(activityTransformer::fromEntity);
  }

  @Override
  public long createActivity(Activity activity) {
    return activityJpaRepository.save(
      new ActivityEntity(activity.getName(), Collections.emptyList()))
      .getId();
  }

  @Override
  public Optional<ActivityRecord> getLatestActivityRecord() {
    return Optional.ofNullable(activityRecordJpaRepository.findTopByOrderByStartDesc()).map(
      e -> new ActivityRecord(e.getId(), e.getStart(), e.getEnd()));
  }

  @Override
  public void createActivityRecord(long activityId, ActivityRecord newRecord) {
    Optional<ActivityEntity> activity = activityJpaRepository.findById(activityId);
    activityRecordJpaRepository.save(new ActivityRecordEntity(
      activity.orElseThrow(IllegalArgumentException::new), newRecord.getStart(),
      newRecord.getEnd()));
  }

  @Override
  public void updateActivityRecord(ActivityRecord activityRecord) {
    Optional<ActivityRecordEntity> record = activityRecordJpaRepository
      .findById(activityRecord.getId());

    record.orElseThrow(IllegalArgumentException::new).setEnd(activityRecord.getEnd());

    activityRecordJpaRepository.save(record.get());
  }
}
