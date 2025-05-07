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

import HS_hrs.employee_service.Entity.Enum.ContractType;
import HS_hrs.employee_service.Entity.Enum.WorkType;

@Entity
@Table(name = "user_employment")
@Getter
public class UserEmployment {

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
}
