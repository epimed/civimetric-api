package civimetric_api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "questionnaire")
@TypeAlias("Questionnaire")

public class Questionnaire {

	@Id
	private String id;
	
	@Field("id_project")
	private String idProject;
	
	private String name;
	
	@Field("creation_date")
	private String creationDate;

	public Questionnaire() {
		super();
	}

	public Questionnaire(String id, String idProject, String name, String creationDate) {
		super();
		this.id = id;
		this.idProject = idProject;
		this.name = name;
		this.creationDate = creationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdProject() {
		return idProject;
	}

	public void setIdProject(String idProject) {
		this.idProject = idProject;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questionnaire other = (Questionnaire) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", idProject=" + idProject + ", name=" + name + ", creationDate="
				+ creationDate + "]";
	}
	
}
