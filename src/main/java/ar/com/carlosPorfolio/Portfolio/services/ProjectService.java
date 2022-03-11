package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.Project;
import ar.com.carlosPorfolio.Portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService{
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getProject() {
        List<Project> listaProject = projectRepository.findAll();
        return listaProject;
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        return project;
    }
}
