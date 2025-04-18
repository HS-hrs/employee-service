package HS_hrs.employee_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class HomeController {

    @GetMapping
    public String home() {
        return "직원 서비스입니다.";
    }
}