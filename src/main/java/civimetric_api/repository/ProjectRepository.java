package civimetric_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import civimetric_api.entity.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {

}
