package org.moshun.botscrew_university_app.repo;

import java.util.List;
import org.moshun.botscrew_university_app.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("SELECT l.firstname, l.lastname FROM Lector l "
            + "WHERE l.firstname LIKE %:param% OR l.lastname LIKE %:param%")
    List<String> globalSearch(@Param("param") String template);
}
