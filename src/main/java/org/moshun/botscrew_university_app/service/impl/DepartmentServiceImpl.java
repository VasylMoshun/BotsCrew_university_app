package org.moshun.botscrew_university_app.service.impl;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.moshun.botscrew_university_app.model.Lector;
import org.moshun.botscrew_university_app.repo.DepartmentRepository;
import org.moshun.botscrew_university_app.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public String getHeadOfDepartment(String departmentName) {
        Optional<Lector> headOfDepartment = departmentRepository.findHeadOfDepartment(departmentName);
        return headOfDepartment.map((lector) -> lector.getFirstname()
                + " " + lector.getLastname()).orElse("Could not find");
    }

    @Override
    public String getLectorsStatistic(String departmentName) {
        int countAssistantsByDepartmentName = departmentRepository
                .countAssistantsByDepartmentName(departmentName);
        int countAssociateProfessorsByDepartmentName = departmentRepository
                .countAssociateProfessorsByDepartmentName(departmentName);
        int countProfessorsByDepartmentName = departmentRepository
                .countProfessorsByDepartmentName(departmentName);
        return "assistants - " + countAssistantsByDepartmentName
                + ", associate professors - " + countAssociateProfessorsByDepartmentName
                + ", professors - " + countProfessorsByDepartmentName;
    }

    @Override
    public String getLectorsAverageSalary(String departmentName) {
        BigDecimal averageSalaryByDepartmentName = departmentRepository
                .findAverageSalaryByDepartmentName(departmentName);
        return averageSalaryByDepartmentName.toString();
    }

    @Override
    public String getCountOfEmployee(String departmentName) {
        int countEmployeesByDepartmentName = departmentRepository
                .countEmployeesByDepartmentName(departmentName);
        return String.valueOf(countEmployeesByDepartmentName);
    }
}
