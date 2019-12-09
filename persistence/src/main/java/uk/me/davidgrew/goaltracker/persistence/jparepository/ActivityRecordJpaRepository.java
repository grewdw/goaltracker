package uk.me.davidgrew.goaltracker.persistence.jparepository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uk.me.davidgrew.goaltracker.persistence.entity.ActivityRecordEntity;

public interface ActivityRecordJpaRepository extends CrudRepository<ActivityRecordEntity, Long> {

  ActivityRecordEntity findTopByOrderByStartDesc();

  @Query(value = "Select * from activity_record ar\n"
    + "where ar.start >= :periodStart and ar.start <= :periodEnd\n"
    + "union all\n"
    + "select * from activity_record ar\n"
    + "where ar.end >= :periodStart and ar.end <= :periodEnd\n"
    + "union all\n"
    + "select * from activity_record ar\n"
    + "where ar.start < :periodStart and ar.end > :periodEnd\n",
    nativeQuery = true)
  List<ActivityRecordEntity> findActivitiesDuringPeriod(
    @Param("periodStart") Instant periodStart,
    @Param("periodEnd") Instant periodEnd);
}
