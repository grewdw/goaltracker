package uk.me.davidgrew.goaltracker.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "uk.me.davidgrew.goaltracker.persistence.jparepository")
@EntityScan(basePackages = "uk.me.davidgrew.goaltracker.persistence.entity")
public class JpaConfiguration {

}
