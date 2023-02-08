package test.task.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.entity.AcceptedRequestEntity;

@Repository
public interface AcceptedRequestEntityRepository extends JpaRepository<AcceptedRequestEntity, Long> {
}