package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.Experience;
import ar.com.carlosPorfolio.Portfolio.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService implements IExperienceService{
    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<Experience> getExperience() {
        List<Experience> listaExperience = experienceRepository.findAll();
        return listaExperience;
    }

    @Override
    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        return experience;
    }
}
