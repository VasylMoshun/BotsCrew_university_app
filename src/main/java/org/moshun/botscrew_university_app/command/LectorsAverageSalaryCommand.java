package org.moshun.botscrew_university_app.command;

import org.moshun.botscrew_university_app.service.DepartmentService;
import org.springframework.stereotype.Component;

@Component
public class LectorsAverageSalaryCommand implements Command{
    private final DepartmentService departmentService;

    public LectorsAverageSalaryCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute(String query) {
        String lectorsAverageSalary = departmentService.getLectorsAverageSalary(query);
        System.out.println("The average salary of "
                + query + " is " + lectorsAverageSalary);
    }

    @Override
    public String getName() {
        return "3";
    }
}
