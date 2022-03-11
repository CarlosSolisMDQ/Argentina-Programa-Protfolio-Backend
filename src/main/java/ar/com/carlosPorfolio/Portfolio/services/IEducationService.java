package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.Education;

import java.util.List;

public interface IEducationService {
    public List<Education> getEducation();
    public void saveEducation(Education education);
    public void deleteEducation(Long id);

    public Education findEducation(Long id);
}
