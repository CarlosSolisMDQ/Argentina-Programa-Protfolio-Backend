package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.Project;

import java.util.List;

public interface IProjectService {
    public List<Project> getProject();
    public void saveProject(Project project);
    public void deleteProject(Long id);

    public Project findProject(Long id);
}
