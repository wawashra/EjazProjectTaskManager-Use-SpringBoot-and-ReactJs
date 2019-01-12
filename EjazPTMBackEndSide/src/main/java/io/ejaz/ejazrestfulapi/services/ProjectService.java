package io.ejaz.ejazrestfulapi.services;

import io.ejaz.ejazrestfulapi.domain.Project;
import io.ejaz.ejazrestfulapi.exception.ProjectIdentifireException;
import io.ejaz.ejazrestfulapi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try{
            return projectRepository.save(project);
        }
        catch (Exception ex){
            throw new ProjectIdentifireException("The Project Identifire ' " + project.getProjectIdentifier() + " ' already exists ! ");
        }
    }
}
