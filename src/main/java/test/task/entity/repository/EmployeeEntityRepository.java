package test.task.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.entity.EmployeeEntity;

import java.util.Optional;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findEmployeeEntitiesByEmail(String email);

}