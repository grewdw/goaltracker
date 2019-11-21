package uk.me.davidgrew.goaltracker.persistence.repository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.me.davidgrew.goaltracker.application.respositories.TaskRepository;
import uk.me.davidgrew.goaltracker.domain.task.Task;
import uk.me.davidgrew.goaltracker.persistence.jparepository.TaskJpaRepository;
import uk.me.davidgrew.goaltracker.persistence.transformer.TaskTransformer;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

  @Autowired
  private TaskJpaRepository taskJpaRepository;

  @Autowired
  private TaskTransformer taskTransformer;

  @Override
  public Optional<Task> getTask(String name) {
    return Optional.ofNullable(taskJpaRepository.findByName(name)).map(taskTransformer::fromEntity);
  }

  @Override
  public void createTask(Task task) {
    taskJpaRepository.save(taskTransformer.toNewEntity(task));
  }
}
