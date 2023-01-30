package test.task.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.entity.KindOfRequestEntity;

import java.util.Optional;

@Repository
public interface KindOfRequestEntityRepository extends JpaRepository<KindOfRequestEntity, Long> {

    Optional<KindOfRequestEntity> findKindOfRequestEntitiesByName(String name);
}