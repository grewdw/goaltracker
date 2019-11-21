package uk.me.davidgrew.goaltracker.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
  "uk.me.davidgrew.goaltracker"
})
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

}
