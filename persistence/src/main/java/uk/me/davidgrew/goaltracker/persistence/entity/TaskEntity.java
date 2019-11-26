package uk.me.davidgrew.goaltracker.persistence.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class TaskEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
  private List<TaskTargetEntity> targets;

  @OneToMany(mappedBy = "task")
  private List<TaskRecordEntity> records;

  public TaskEntity() {
  }

  public TaskEntity(String name, List<TaskTargetEntity> targets) {
    this.name = name;
    this.targets = targets;
    targets.forEach(target -> target.setTaskEntity(this));
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<TaskTargetEntity> getTargets() {
    return targets;
  }

  public List<TaskRecordEntity> getRecords() {
    return records;
  }
}
