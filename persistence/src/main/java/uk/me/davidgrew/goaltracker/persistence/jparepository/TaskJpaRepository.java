package uk.me.davidgrew.goaltracker.persistence.jparepository;

import org.springframework.data.repository.CrudRepository;
import uk.me.davidgrew.goaltracker.persistence.entity.TaskEntity;

public interface TaskJpaRepository extends CrudRepository<TaskEntity, Long> {

  TaskEntity findByName(String name);
}
