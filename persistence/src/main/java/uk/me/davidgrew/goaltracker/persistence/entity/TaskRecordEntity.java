package uk.me.davidgrew.goaltracker.persistence.entity;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_RECORD")
public class TaskRecordEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private int count;
  private Instant time;

  @ManyToOne(fetch = FetchType.LAZY)
  private TaskEntity task;

  private TaskRecordEntity() {
  }

  public TaskRecordEntity(int count, Instant time,
    TaskEntity task) {
    this.count = count;
    this.time = time;
    this.task = task;
  }

  public Long getId() {
    return id;
  }

  public int getCount() {
    return count;
  }

  public Instant getTime() {
    return time;
  }

  public TaskEntity getTask() {
    return task;
  }
}
