package uk.me.davidgrew.goaltracker.persistence.jparepository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityEntity;

public interface ActivityJpaRepository extends CrudRepository<ActivityEntity, Long> {

  List<ActivityEntity> findAll();

  ActivityEntity findByName(String name);
}
