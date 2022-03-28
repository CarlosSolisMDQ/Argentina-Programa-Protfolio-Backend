package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.UiPortfolioimages;
import ar.com.carlosPorfolio.Portfolio.repository.UiPortfolioImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UiPortfolioImagesService implements IUIPortfolioImagesService{

    @Autowired
    private UiPortfolioImagesRepository uiPortfolioImagesRepository;

    @Override
    public List<UiPortfolioimages> getUiPortfolioimages() {
        List<UiPortfolioimages> images = uiPortfolioImagesRepository.findAll();
        return images;
    }

    @Override
    public void saveUiPortfolioimages(UiPortfolioimages uiPortfolioimages) {
        uiPortfolioImagesRepository.save(uiPortfolioimages);
    }

    @Override
    public void deleteUiPortfolioimages(Long id) {
        uiPortfolioImagesRepository.deleteById(id);
    }

    @Override
    public UiPortfolioimages findUiPortfolioimages(Long id) {
        UiPortfolioimages images = uiPortfolioImagesRepository.findById(id).orElse(null);
        return images;
    }
}
