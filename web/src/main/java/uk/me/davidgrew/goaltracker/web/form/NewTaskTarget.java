package uk.me.davidgrew.goaltracker.web.form;

import uk.me.davidgrew.goaltracker.domain.task.TargetDirection;
import uk.me.davidgrew.goaltracker.domain.task.TargetPeriod;

public class NewTaskTarget {

  private TargetPeriod period;
  private TargetDirection direction;
  private int count;

  private NewTaskTarget() {
    //for Jackson serialisation
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
}
