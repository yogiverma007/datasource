package com.freedom.datasource.service;

import com.freedom.datasource.dto.EmployeeExtendedInfoDto;
import com.freedom.datasource.model.Employee;
import com.freedom.datasource.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public Long saveEmployee() {
    Employee employee = new Employee();
    employee.setName("Yogesh Verma");
    employee.setAddress("Karnal Haryana India");
    employee.setContact(ThreadLocalRandom.current().nextLong(1000000000l, 9999999999l) + "");
    employee.setStatus("ACTIVE");
    employee.setExtendedInfo(
        new EmployeeExtendedInfoDto(
            ThreadLocalRandom.current().nextLong(100000l, 300000l),
            ThreadLocalRandom.current().nextLong(1000000000l, 9999999999l) + ""));
    employee = employeeRepository.save(employee);
    return employee.getId();
  }

  public void getEmployee(long id) {
    Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    if (optionalEmployee.isPresent()) {
      log.info("Employee:{}", optionalEmployee.get());
    }
  }

  @Scheduled(fixedDelay = 2000L)
  public void init() {
    Long id = saveEmployee();
    getEmployee(id);
  }
}
