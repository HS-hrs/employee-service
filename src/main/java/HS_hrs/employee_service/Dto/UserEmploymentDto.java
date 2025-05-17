package HS_hrs.employee_service.Dto;
import lombok.Getter;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.Builder;
import HS_hrs.employee_service.Entity.Enum.ContractType;
import HS_hrs.employee_service.Entity.Enum.WorkType;
import jakarta.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class UserEmploymentDto {
    @NotBlank
    private Long id;
    private Integer userId;
    private String position;
    private String department;
    private LocalDateTime joinDate;
    private LocalDateTime resignationDate;
    private ContractType contractType;
    private WorkType workType;

    @Builder
    public UserEmploymentDto(Long id, Integer userId, String position, String department, LocalDateTime joinDate, LocalDateTime resignationDate, ContractType contractType, WorkType workType) {
        this.id = id;
        this.userId = userId;
        this.position = position;
        this.department = department;
        this.joinDate = joinDate;
        this.resignationDate = resignationDate;
        this.contractType = contractType;
        this.workType = workType;
    }
}