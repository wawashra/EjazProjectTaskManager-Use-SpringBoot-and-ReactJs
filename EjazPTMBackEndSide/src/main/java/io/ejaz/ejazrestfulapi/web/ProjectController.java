package io.ejaz.ejazrestfulapi.web;

import io.ejaz.ejazrestfulapi.domain.Project;
import io.ejaz.ejazrestfulapi.services.MapValidationErrorService;
import io.ejaz.ejazrestfulapi.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
}
