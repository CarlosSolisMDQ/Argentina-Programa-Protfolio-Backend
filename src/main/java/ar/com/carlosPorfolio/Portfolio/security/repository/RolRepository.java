package ar.com.carlosPorfolio.Portfolio.security.repository;

import ar.com.carlosPorfolio.Portfolio.security.entity.Rol;
import ar.com.carlosPorfolio.Portfolio.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
