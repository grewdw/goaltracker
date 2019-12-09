package uk.me.davidgrew.goaltracker.web.form;

import java.time.ZonedDateTime;

public class ActivityRecordForm {

  private ZonedDateTime start;
  private ZonedDateTime end;

  // for jackson serialisation
  private ActivityRecordForm() {
  }

  public ZonedDateTime getStart() {
    return start;
  }

  public ZonedDateTime getEnd() {
    return end;
  }
}
