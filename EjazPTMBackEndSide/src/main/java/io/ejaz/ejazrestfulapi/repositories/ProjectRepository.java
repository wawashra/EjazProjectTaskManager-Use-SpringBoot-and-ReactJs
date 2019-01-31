package io.ejaz.ejazrestfulapi.repositories;

import io.ejaz.ejazrestfulapi.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
    /*
     * to return Project forum DataBase by projectIdentifier Attribute .
     */
    Project findByProjectIdentifier(String projectIdentifier);

    /*
     * to return allProject forum DataBase .
     */
    @Override
    Iterable<Project> findAll();
}
