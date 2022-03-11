package ar.com.carlosPorfolio.Portfolio.repository;

import ar.com.carlosPorfolio.Portfolio.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
