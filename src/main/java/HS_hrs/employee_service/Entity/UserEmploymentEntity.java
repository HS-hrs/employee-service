package HS_hrs.employee_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.time.LocalDateTime;
import lombok.Builder;

import HS_hrs.employee_service.Dto.UserEmploymentDto;
import HS_hrs.employee_service.Entity.Enum.ContractType;
import HS_hrs.employee_service.Entity.Enum.WorkType;

@Entity
@Table(name = "user_employment")
@Getter
@Builder
public class UserEmploymentEntity {

    public UserEmploymentEntity() {
    }
    @Builder
    public UserEmploymentEntity(Long id, Integer userId, String position, String department, LocalDateTime joinDate, LocalDateTime resignationDate, ContractType contractType, WorkType workType) {
        this.id = id;
        this.userId = userId;
        this.position = position;
        this.department = department;
        this.joinDate = joinDate;
        this.resignationDate = resignationDate;
        this.contractType = contractType;
        this.workType = workType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Integer userId; 
    // 사용자 식별자

    @Column(nullable = false, length = 50)
    private String position;

    @Column(nullable = false, length = 50)
    private String department;

    @Column(name = "join_date", nullable = false)
    private LocalDateTime joinDate;

    @Column(name = "resignation_date")
    private LocalDateTime resignationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type", nullable = false)
    private ContractType contractType;
    // REQULAR, CONTRACT, INTERN

    @Enumerated(EnumType.STRING)
    @Column(name = "work_type", nullable = false)
    private WorkType workType;
    
    // FULL_TIME, PART_TIME
    public static UserEmploymentEntity toEntity(UserEmploymentDto userEmploymentDto) {
        return UserEmploymentEntity.builder()
            .userId(userEmploymentDto.getUserId())
            .position(userEmploymentDto.getPosition())
            .department(userEmploymentDto.getDepartment())
            .joinDate(userEmploymentDto.getJoinDate())
            .resignationDate(userEmploymentDto.getResignationDate())
            .contractType(userEmploymentDto.getContractType())
            .workType(userEmploymentDto.getWorkType())
            .build();
    }

    public static UserEmploymentDto toDto(UserEmploymentEntity userEmploymentEntity) {
        return UserEmploymentDto.builder()
            .id(userEmploymentEntity.getId())
            .userId(userEmploymentEntity.getUserId())
            .position(userEmploymentEntity.getPosition())
            .department(userEmploymentEntity.getDepartment())
            .joinDate(userEmploymentEntity.getJoinDate())
            .resignationDate(userEmploymentEntity.getResignationDate())
            .contractType(userEmploymentEntity.getContractType())
            .workType(userEmploymentEntity.getWorkType())
            .build();
    }

    public void updateUserEmployment(UserEmploymentDto userEmploymentDto) {
        this.position = userEmploymentDto.getPosition();
        this.department = userEmploymentDto.getDepartment();
        this.resignationDate = userEmploymentDto.getResignationDate();
        this.contractType = userEmploymentDto.getContractType();
        this.workType = userEmploymentDto.getWorkType();
    }

}
