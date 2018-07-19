package civimetric_api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import civimetric_api.entity.Project;
import civimetric_api.entity.Questionnaire;
import civimetric_api.form.QuestionnaireForm;
import civimetric_api.repository.ProjectRepository;
import civimetric_api.repository.QuestionnaireRepository;
import civimetric_api.service.logger.ApplicationLogger;

@RestController
public class QuestionnaireController extends ApplicationLogger {
	
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@RequestMapping(value = "/questionnaire/init", method = RequestMethod.GET)
	public void init(HttpServletResponse response) throws IOException {
		logger.debug("Creating new project");
		questionnaireRepository.save(new Questionnaire("Q001", "P001", "My first questionnaire", "2017-01-01"));
		questionnaireRepository.save(new Questionnaire("Q002", "P002", "My second questionnaire", "2018-01-01"));
		response.sendRedirect("../questionnaires");
	}
	
	@RequestMapping(value = "/questionnaire/{idQuestionnaire}", method = RequestMethod.GET)
	public Questionnaire findById(@PathVariable String idQuestionnaire) {
		Optional<Questionnaire> questionnaire = questionnaireRepository.findById(idQuestionnaire);
		return questionnaire.orElse(new Questionnaire());
	}
	
	@RequestMapping(value = "/questionnaire/lookup/{idQuestionnaire}", method = RequestMethod.GET)
	public QuestionnaireForm lookup(@PathVariable String idQuestionnaire) {
		return questionnaireRepository.lookup(idQuestionnaire);
	}
	
	@RequestMapping(value = "/questionnaire/join/{idQuestionnaire}", method = RequestMethod.GET)
	public Object join(@PathVariable String idQuestionnaire) {
		Map<String, Object> result = new HashMap<String, Object>();
		Optional<Questionnaire> questionnaire = questionnaireRepository.findById(idQuestionnaire);
		result.put("questionnaire", questionnaire.orElse(new Questionnaire()));
		if (questionnaire.isPresent()) {
			Optional<Project> project = projectRepository.findById(questionnaire.get().getIdProject());
			result.put("project", project.orElse(new Project()));
		}
		return result;
	}
	
	@RequestMapping(value = "/questionnaires", method = RequestMethod.GET)
	public List<Questionnaire> findAll() {
		List<Questionnaire> questionnaires = questionnaireRepository.findAll();
		return questionnaires;
	}
	
	@RequestMapping(value = "/questionnaires/project/{idProject}", method = RequestMethod.GET)
	public List<Questionnaire> findByIdProject(@PathVariable String idProject) {
		List<Questionnaire> questionnaires = questionnaireRepository.findByIdProject(idProject);
		return questionnaires;
	}

}
