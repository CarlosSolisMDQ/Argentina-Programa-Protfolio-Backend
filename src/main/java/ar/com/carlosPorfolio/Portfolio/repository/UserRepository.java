package ar.com.carlosPorfolio.Portfolio.repository;


import ar.com.carlosPorfolio.Portfolio.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
