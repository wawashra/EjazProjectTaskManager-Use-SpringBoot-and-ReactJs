package io.ejaz.ejazrestfulapi.web;

import io.ejaz.ejazrestfulapi.domain.Project;
import io.ejaz.ejazrestfulapi.services.MapValidationErrorService;
import io.ejaz.ejazrestfulapi.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project , BindingResult result){
        ResponseEntity<?> mapError = mapValidationErrorService.MapValidationService(result);
        if(mapError != null )
            return mapError;
        return new ResponseEntity<Project>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }

    /*
     * This WebService use findProjectByIdentifier Service to
     * return Project forum DataBase by projectIdentifier Attribute .
     */
    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> findProjectsByProjectIdentifier(@PathVariable String projectIdentifier){
        Project toReturn = projectService.findProjectByIdentifier(projectIdentifier);
        return new ResponseEntity<Project>(toReturn,HttpStatus.OK);
    }

    /*
     * This WebService use findAllProject Method To return all Project forum DataBase
     */
    @GetMapping("/all")
    public Iterable<Project> findAllProject(){
        return projectService.findAllProject();
    }

    /*
     * This Method to remove project forum DataBase by projectIdentifier Attribute
     */
    @DeleteMapping("/{projectIdentifier}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectIdentifier){
        projectService.deleteProjectByIdentifier(projectIdentifier);
        return new ResponseEntity<String>("Project with ID: '"+projectIdentifier+"' was deleted",HttpStatus.OK);
    }
}
