package uk.me.davidgrew.goaltracker.persistence.repository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.me.davidgrew.goaltracker.application.respositories.TaskRepository;
import uk.me.davidgrew.goaltracker.domain.task.Task;
import uk.me.davidgrew.goaltracker.domain.task.TaskRecord;
import uk.me.davidgrew.goaltracker.persistence.entity.TaskEntity;
import uk.me.davidgrew.goaltracker.persistence.entity.TaskRecordEntity;
import uk.me.davidgrew.goaltracker.persistence.jparepository.TaskJpaRepository;
import uk.me.davidgrew.goaltracker.persistence.jparepository.TaskRecordJpaRepository;
import uk.me.davidgrew.goaltracker.persistence.transformer.TaskTransformer;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

  @Autowired
  private TaskJpaRepository taskJpaRepository;

  @Autowired
  private TaskRecordJpaRepository taskRecordJpaRepository;

  @Autowired
  private TaskTransformer taskTransformer;

  @Override
  public Optional<Task> getTask(String name) {
    return Optional.ofNullable(taskJpaRepository.findByName(name)).map(taskTransformer::fromEntity);
  }

  @Override
  public boolean taskExists(long id) {
    return taskJpaRepository.existsById(id);
  }

  @Override
  public void createTask(Task task) {
    taskJpaRepository.save(taskTransformer.toNewEntity(task));
  }

  @Override
  public void addTaskRecord(long taskId, TaskRecord record) {
    TaskEntity taskEntity = taskJpaRepository.findById(taskId)
      .orElseThrow(IllegalArgumentException::new);
    taskRecordJpaRepository
      .save(new TaskRecordEntity(record.getCount(), record.getTime(), taskEntity));
  }
}
