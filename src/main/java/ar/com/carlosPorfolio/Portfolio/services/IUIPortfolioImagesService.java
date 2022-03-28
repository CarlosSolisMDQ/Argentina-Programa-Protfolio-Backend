package ar.com.carlosPorfolio.Portfolio.services;


import ar.com.carlosPorfolio.Portfolio.models.UiPortfolioimages;

import java.util.List;

public interface IUIPortfolioImagesService {
    public List<UiPortfolioimages> getUiPortfolioimages();

    public void saveUiPortfolioimages(UiPortfolioimages uiPortfolioimages);

    public void deleteUiPortfolioimages(Long id);

    public UiPortfolioimages findUiPortfolioimages(Long id);
}
