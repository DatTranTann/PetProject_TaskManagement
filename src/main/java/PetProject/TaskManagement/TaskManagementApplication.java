package PetProject.TaskManagement;

import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@EnableWebSecurity
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
//	@Bean
//	CommandLineRunner run (EmployeeService employeeService){
//		return args -> {
//			employeeService.create(new Employee(UUID.randomUUID(),"Dat","Tran","DatTran","dat12345", "Tran Tan Dat", "trandat123@gmail.com", LocalDateTime.now(), false, LocalDateTime.now(), "00000000-0000-0000-0000-000000000000", LocalDateTime.now(), "00000000-0000-0000-0000-000000000000"));
//		};
//	}
}
