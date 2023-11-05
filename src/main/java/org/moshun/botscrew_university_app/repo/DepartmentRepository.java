package org.moshun.botscrew_university_app.repo;

import java.math.BigDecimal;
import java.util.Optional;
import org.moshun.botscrew_university_app.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.moshun.botscrew_university_app.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);

    @Query("SELECT l FROM Department d JOIN Lector l ON d.headOfDepartment.id = l.id "
            + "WHERE d.name = :departmentName")
    Optional<Lector> findHeadOfDepartment(@Param("departmentName") String departmentName);

    @Query("SELECT COUNT(l) FROM Department d JOIN d.personnel l "
            + "WHERE d.name = :departmentName AND l.degree = 'ASSISTANT'")
    int countAssistantsByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT COUNT(l) FROM Department d JOIN d.personnel l "
            + "WHERE d.name = :departmentName AND l.degree = 'ASSOCIATE_PROFESSOR'")
    int countAssociateProfessorsByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT COUNT(l) FROM Department d JOIN d.personnel l "
            + "WHERE d.name = :departmentName AND l.degree = 'PROFESSOR'")
    int countProfessorsByDepartmentName(@Param("departmentName") String departmentName);


    @Query("SELECT AVG(l.salary) FROM Department d "
            + "JOIN d.personnel l WHERE d.name = :departmentName")
    BigDecimal findAverageSalaryByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT COUNT(l) FROM Department d JOIN d.personnel l WHERE d.name = :departmentName")
    int countEmployeesByDepartmentName(@Param("departmentName") String departmentName);
}
