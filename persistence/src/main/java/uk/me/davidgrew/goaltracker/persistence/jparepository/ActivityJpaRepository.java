package uk.me.davidgrew.goaltracker.persistence.jparepository;

import org.springframework.data.repository.CrudRepository;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityEntity;

public interface ActivityJpaRepository extends CrudRepository<ActivityEntity, Long> {

  ActivityEntity findByName(String name);
}
