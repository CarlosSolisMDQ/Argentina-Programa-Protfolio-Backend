package ar.com.carlosPorfolio.Portfolio.repository;


import ar.com.carlosPorfolio.Portfolio.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
