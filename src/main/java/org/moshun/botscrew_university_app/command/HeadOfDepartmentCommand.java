package org.moshun.botscrew_university_app.command;

import org.moshun.botscrew_university_app.service.DepartmentService;
import org.springframework.stereotype.Component;

@Component
public class HeadOfDepartmentCommand implements Command {
    private final DepartmentService departmentService;

    public HeadOfDepartmentCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute(String query) {
        String headOfDepartment = departmentService.getHeadOfDepartment(query);
        System.out.println("Head of " + query + " department is " + headOfDepartment);
    }

    @Override
    public String getName() {
        return "1";
    }
}
