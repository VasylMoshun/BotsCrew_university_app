package org.moshun.botscrew_university_app.service;

public interface DepartmentService {
    String getHeadOfDepartment(String departmentName);

    String getLectorsStatistic(String departmentName);

    String getLectorsAverageSalary(String departmentName);

    String getCountOfEmployee(String departmentName);
}
