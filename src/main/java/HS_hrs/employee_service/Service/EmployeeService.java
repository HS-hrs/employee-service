package HS_hrs.employee_service.Service;

import org.springframework.stereotype.Service;
import HS_hrs.employee_service.Repository.EmployeeRepository;
import HS_hrs.employee_service.Entity.UserEmploymentEntity;
import HS_hrs.employee_service.Dto.UserEmploymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    @Transactional
    public void updateUserEmployment(UserEmploymentDto userEmploymentDto) {
        UserEmploymentEntity updatedUserEmployment = this.getUserEmployment(userEmploymentDto.getId());
        updatedUserEmployment.updateUserEmployment(userEmploymentDto);
        this.employeeRepository.save(updatedUserEmployment);
    }

    public UserEmploymentEntity getUserEmployment(Long Id) {
        return employeeRepository.findById(Id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserEmploymentDto getUserEmploymentDto(Long Id) {
        UserEmploymentEntity userEmploymentEntity = employeeRepository.findById(Id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return UserEmploymentEntity.toDto(userEmploymentEntity);
    }

    public List<UserEmploymentDto> getAllUserEmployments() {
        List<UserEmploymentEntity> userEmploymentEntities = employeeRepository.findAll();
        return userEmploymentEntities.stream()
            .map(UserEmploymentEntity::toDto)
            .collect(Collectors.toList());
    }

    public UserEmploymentEntity createUserEmployment(UserEmploymentDto userEmploymentDto) {
        return employeeRepository.save(UserEmploymentEntity.toEntity(userEmploymentDto));
    }
}
