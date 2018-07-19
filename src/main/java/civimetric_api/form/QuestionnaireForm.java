package civimetric_api.form;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import civimetric_api.entity.Project;

@Document(collection = "questionnaire")
@TypeAlias("QuestionnaireForm")
public class QuestionnaireForm {

	@Id
	private String id;
	
	private Project project;
	
	private String name;
	
	@Field("creation_date")
	private String creationDate;
	
	public QuestionnaireForm() {
		super();
	}
	
	public QuestionnaireForm(String id, Project project, String name, String creationDate) {
		super();
		this.id = id;
		this.project = project;
		this.name = name;
		this.creationDate = creationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "QuestionnaireForm [id=" + id + ", project=" + project + ", name=" + name + ", creationDate="
				+ creationDate + "]";
	}
	
}
