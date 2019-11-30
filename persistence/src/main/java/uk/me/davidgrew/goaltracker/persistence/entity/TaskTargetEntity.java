package uk.me.davidgrew.goaltracker.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import uk.me.davidgrew.goaltracker.domain.task.TargetDirection;
import uk.me.davidgrew.goaltracker.domain.task.TargetPeriod;

@Entity
@Table(name = "TASK_TARGET")
public class TaskTargetEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private TargetPeriod period;
  private TargetDirection direction;
  private int count;
  private boolean current;

  @ManyToOne(fetch = FetchType.LAZY)
  private TaskEntity task;

  public TaskTargetEntity() {
  }

  public TaskTargetEntity(TargetPeriod period, TargetDirection direction, int count,
    boolean current) {
    this.period = period;
    this.direction = direction;
    this.count = count;
    this.current = current;
  }

  public void setTaskEntity(TaskEntity taskEntity) {
    this.task = taskEntity;
  }

  public Long getId() {
    return id;
  }

  public TargetPeriod getPeriod() {
    return period;
  }

  public TargetDirection getDirection() {
    return direction;
  }

  public int getCount() {
    return count;
  }

  public boolean isCurrent() {
    return current;
  }
}
