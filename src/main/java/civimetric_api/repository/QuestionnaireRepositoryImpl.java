package civimetric_api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import civimetric_api.form.QuestionnaireForm;

public class QuestionnaireRepositoryImpl implements QuestionnaireRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public QuestionnaireForm lookup(String idQuestionnaire) {
		MatchOperation matchOperation = Aggregation.match(Criteria.where("_id").is(idQuestionnaire));
		LookupOperation lookupOperation = LookupOperation.newLookup()
				.from("project")
				.localField("id_project")
				.foreignField("_id")
				.as("project");

		Aggregation aggregation = Aggregation.newAggregation(matchOperation, lookupOperation);
		return mongoTemplate.aggregate(aggregation, "questionnaire", QuestionnaireForm.class).getUniqueMappedResult();

	}

}
