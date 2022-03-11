package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.About;
import ar.com.carlosPorfolio.Portfolio.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutService implements IAboutService{
    @Autowired
    private AboutRepository aboutRepository;

    @Override
    public List<About> getAbout() {
        List<About> listabout = aboutRepository.findAll();
        return listabout;
    }

    @Override
    public void saveAbout(About about) {
        aboutRepository.save(about);
    }

    @Override
    public void deleteAbout(Long id) {
        aboutRepository.deleteById(id);
    }

    @Override
    public About findAbout(Long id) {
        About about = aboutRepository.findById(id).orElse(null);
        return about;
    }
}
