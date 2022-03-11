package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.Education;
import ar.com.carlosPorfolio.Portfolio.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService{
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public List<Education> getEducation() {
        List<Education> listaEducation = educationRepository.findAll();
        return listaEducation;
    }

    @Override
    public void saveEducation(Education education) {
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education education = educationRepository.findById(id).orElse(null);
        return education;

    }
}
