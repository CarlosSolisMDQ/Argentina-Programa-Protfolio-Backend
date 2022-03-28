package ar.com.carlosPorfolio.Portfolio.repository;


import ar.com.carlosPorfolio.Portfolio.models.UiPortfolioimages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UiPortfolioImagesRepository extends JpaRepository<UiPortfolioimages, Long> {
}
