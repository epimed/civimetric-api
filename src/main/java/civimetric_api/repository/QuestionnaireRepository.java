package civimetric_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import civimetric_api.entity.Questionnaire;

public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String>, QuestionnaireRepositoryCustom {

	public List<Questionnaire> findByIdProject(String idProject);
	
}
