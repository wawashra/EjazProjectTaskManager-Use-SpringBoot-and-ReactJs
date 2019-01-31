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

    /*
     * This method to save || update project forum DataBase .
     */
    public Project saveOrUpdateProject(Project project){
        try{
            return projectRepository.save(project);
        }
        catch (Exception ex){
            throw new ProjectIdentifireException("The Project Identifire ' " + project.getProjectIdentifier() + " ' already exists ! ");
        }
    }

    /*
     * This method to return Project forum DataBase by projectIdentifier Attribute .
     */
    public Project findProjectByIdentifier(String projectIdentifier){
        Project toReturn = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if(toReturn == null)
            throw new ProjectIdentifireException("The Project Identifire ' " + projectIdentifier + " ' dose not exists ! ");

        return toReturn;

    }

    /*
     * This Method to return All project forum DataBase .
     */
    public Iterable<Project> findAllProject(){
        return projectRepository.findAll();
    }

    /*
     * This method to remove Project forum DataBase by projectIdentifier Attribute .
     */
    public void deleteProjectByIdentifier(String projectIdentifier){
        Project toRemove = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if(toRemove == null)
            throw new ProjectIdentifireException("The Project Identifire ' " + projectIdentifier + " ' dose not exists ! ");

        projectRepository.delete(toRemove);
    }
}
