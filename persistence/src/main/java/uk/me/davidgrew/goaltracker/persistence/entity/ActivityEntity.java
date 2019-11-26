package uk.me.davidgrew.goaltracker.persistence.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITY")
public class ActivityEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private List<ActivityRecordEntity> activityRecords;

  private ActivityEntity() {
  }

  public ActivityEntity(String name, List<ActivityRecordEntity> activityRecords) {
    this.name = name;
    this.activityRecords = activityRecords;
    activityRecords.forEach(record -> record.setActivity(this));
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<ActivityRecordEntity> getActivityRecords() {
    return activityRecords;
  }
}
