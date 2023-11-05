package org.moshun.botscrew_university_app.command;

import org.moshun.botscrew_university_app.service.DepartmentService;
import org.springframework.stereotype.Component;

@Component
public class LectorsStatisticCommand implements Command{
    private final DepartmentService departmentService;

    public LectorsStatisticCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute(String query) {
        String lectorsStatistic = departmentService.getLectorsStatistic(query);
        System.out.println(lectorsStatistic);
    }

    @Override
    public String getName() {
        return "2";
    }
}
