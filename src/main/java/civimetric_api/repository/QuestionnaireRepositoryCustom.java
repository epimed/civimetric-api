package civimetric_api.repository;

import civimetric_api.form.QuestionnaireForm;

public interface QuestionnaireRepositoryCustom {

	public QuestionnaireForm lookup(String idQuestionnaire);
	
}
