package uk.me.davidgrew.goaltracker.persistence.jparepository;

import org.springframework.data.repository.CrudRepository;
import uk.me.davidgrew.goaltracker.persistence.entity.TaskRecordEntity;

public interface TaskRecordJpaRepository extends CrudRepository<TaskRecordEntity, Long> {

}
