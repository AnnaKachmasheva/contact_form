package test.task.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.entity.RequestEntity;

@Repository
public interface RequestEntityRepository extends JpaRepository<RequestEntity, Long> {
}