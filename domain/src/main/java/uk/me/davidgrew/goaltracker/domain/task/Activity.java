package uk.me.davidgrew.goaltracker.domain.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

public class Activity {

  @JsonProperty("id")
  private long id;
  @JsonProperty("name")
  private String name;

  public Activity(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Activity(String name) {
    this.name = Arrays.stream(name.toLowerCase().stripLeading().stripTrailing()
      .split(" "))
      .map(StringUtils::capitalize)
      .collect(Collectors.joining(" "));
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
