package HS_hrs.employee_service.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.env.Environment;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import HS_hrs.employee_service.Dto.UserEmploymentDto;
import HS_hrs.employee_service.Service.EmployeeService;

@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeServiceController {

  private final Environment env;
  private final EmployeeService employeeService;

    @Tag(name = "forTest", description = "테스트 API")
    @GetMapping("/home")
    @Operation(summary = "직원 서비스 홈", description = "직원 서비스 기본 엔드포인트")
    public String home() {
        return "직원 서비스입니다.";
    }

    @Tag(name = "forTest", description = "테스트 API")
    @GetMapping("/check")
    @Operation(summary = "서버 포트 확인", description = "서버 포트 확인 엔드포인트")
    public String check(HttpServletRequest request) {
      log.info("Server port={}", request.getServerPort());
      return String.format("Check from Server running at port %s", env.getProperty("local.server.port"));
    }

    @Tag(name = "employeeAPI", description = "직원 정보 API")
    @Parameters({
      @Parameter(name = "userEmploymentDto", description = "직원 정보")
    })
    @PostMapping("/saveEmployment")
    @Operation(summary = "직원 정보 등록", description = "직원 정보 등록 엔드포인트")
    public String createEmployment(@RequestBody UserEmploymentDto userEmploymentDto) {
      employeeService.createUserEmployment(userEmploymentDto);
      return "등록 완료";
    }

    @Tag(name = "employeeAPI", description = "직원 정보 API")
    @Parameters({
      @Parameter(name = "userEmploymentDto", description = "직원 정보")
    })
    @PostMapping("/updateEmployment")
    @Operation(summary = "직원 정보 수정", description = "직원 정보 수정 엔드포인트")
    public String updateEmployment(@RequestBody UserEmploymentDto userEmploymentDto) {
      employeeService.updateUserEmployment(userEmploymentDto);
      return "수정 완료";
    }

    @Tag(name = "employeeAPI", description = "직원 정보 API")
    @GetMapping("/getAllUserEmployments")
    @Operation(summary = "모든 직원 정보 조회", description = "모든 직원 정보 조회 엔드포인트")
    public List<UserEmploymentDto> getAllUserEmployments() {
      return employeeService.getAllUserEmployments();
    }

    @Tag(name = "employeeAPI", description = "직원 정보 API")
    @GetMapping("/getUserEmployment/{id}")
    @Operation(summary = "직원 정보 조회", description = "직원 정보 조회 엔드포인트")
    public UserEmploymentDto getUserEmployment(@PathVariable(name = "id", required = true) Long id) {
      
      return employeeService.getUserEmploymentDto(id);
    }


}