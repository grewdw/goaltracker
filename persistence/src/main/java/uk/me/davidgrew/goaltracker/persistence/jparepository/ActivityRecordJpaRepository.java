package uk.me.davidgrew.goaltracker.persistence.jparepository;

import org.springframework.data.repository.CrudRepository;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityRecordEntity;

public interface ActivityRecordJpaRepository extends CrudRepository<ActivityRecordEntity, Long> {

  ActivityRecordEntity findTopByOrderByStartDesc();
}
