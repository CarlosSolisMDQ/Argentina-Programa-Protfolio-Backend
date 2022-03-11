package ar.com.carlosPorfolio.Portfolio.repository;

import ar.com.carlosPorfolio.Portfolio.models.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
}
