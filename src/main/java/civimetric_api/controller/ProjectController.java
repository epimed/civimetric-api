package civimetric_api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import civimetric_api.entity.Project;
import civimetric_api.repository.ProjectRepository;
import civimetric_api.service.logger.ApplicationLogger;

@RestController
public class ProjectController extends ApplicationLogger {
	

	@Autowired
	private ProjectRepository projectRepository;
	
	@RequestMapping(value = "/project/init", method = RequestMethod.GET)
	public void initProject(HttpServletResponse response) throws IOException {
		logger.debug("Creating new project");
		projectRepository.save(new Project("P001", "My first project", "My first sponsor", 2018));
		projectRepository.save(new Project("P002", "My second project", "My second sponsor", 2018));
		response.sendRedirect("../projects");
	}
	
	@RequestMapping(value = "/project/{idProject}", method = RequestMethod.GET)
	public Project findProject(@PathVariable String idProject) {
		Optional<Project> project = projectRepository.findById(idProject);
		return project.orElse(new Project());
	}
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public List<Project> findAllProjects() {
		List<Project> projects = projectRepository.findAll();
		return projects;
	}

}
