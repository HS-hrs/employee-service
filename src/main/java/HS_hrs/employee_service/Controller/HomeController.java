package HS_hrs.employee_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/employee")
    public String home() {
        return "직원 서비스입니다.";
    }
}