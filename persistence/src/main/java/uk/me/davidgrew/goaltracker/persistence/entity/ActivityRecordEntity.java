package uk.me.davidgrew.goaltracker.persistence.entity;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITY_RECORD")
public class ActivityRecordEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private ActivityEntity activity;

  private Instant start;

  private Instant end;

  private ActivityRecordEntity() {
  }

  public ActivityRecordEntity(Instant start, Instant end) {
    this.start = start;
    this.end = end;
  }

  public ActivityRecordEntity(ActivityEntity activity, Instant start, Instant end) {
    this.activity = activity;
    this.start = start;
    this.end = end;
  }

  public Long getId() {
    return id;
  }

  public ActivityEntity getActivity() {
    return activity;
  }

  public void setActivity(ActivityEntity activity) {
    this.activity = activity;
  }

  public Instant getStart() {
    return start;
  }

  public Instant getEnd() {
    return end;
  }

  public void setEnd(Instant end) {
    this.end = end;
  }
}
