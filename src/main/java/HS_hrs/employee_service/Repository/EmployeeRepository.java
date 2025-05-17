package HS_hrs.employee_service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import HS_hrs.employee_service.Entity.UserEmploymentEntity;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<UserEmploymentEntity, Long> {
    Optional<UserEmploymentEntity> findById(Integer Id);
}
