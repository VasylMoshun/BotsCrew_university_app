package org.moshun.botscrew_university_app.command;

import org.moshun.botscrew_university_app.service.DepartmentService;
import org.springframework.stereotype.Component;

@Component
public class CountOfEmployeeCommand implements Command{
    private final DepartmentService departmentService;

    public CountOfEmployeeCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute(String query) {
        String countOfEmployee = departmentService.getCountOfEmployee(query);
        System.out.println("Employee in " + query + " : " + countOfEmployee);
    }

    @Override
    public String getName() {
        return "4";
    }
}
