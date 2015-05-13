package com.boldijarpaul.rest.servlets;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.boldijarpaul.rest.entities.RequestResult;
import com.boldijarpaul.rest.entities.Score;
import com.boldijarpaul.rest.helper.GsonHelper;
import com.boldijarpaul.rest.service.ServiceLocator;

@Path("/scores")
public class ScoresServlet {

	@GET
	@Path("/getall")
	public String getScoresJson() {
		List<Score> scores = ServiceLocator.getScoreManagement().getAllScores();
		RequestResult requestResult = new RequestResult("Success",
				RequestResult.Codes.SUCCESS, scores);
		return GsonHelper.objectToJsonString(requestResult);
	}

	@Path("/add")
	@GET
	public String addScore(@DefaultValue("-1") @QueryParam("value") long value,
			@DefaultValue("") @QueryParam("name") String name) {
		/* if score or value not provided */
		RequestResult requestResult = new RequestResult();
		if (value == -1) {
			requestResult.setMessage("Please set the score value as well.");
			requestResult.setCode(RequestResult.Codes.PARAMETER_MISSING);
			return GsonHelper.objectToJsonString(requestResult);
		}
		if (name.trim().length() == 0) {
			requestResult.setMessage("Please set the name value as well.");
			requestResult.setCode(RequestResult.Codes.PARAMETER_MISSING);
			return GsonHelper.objectToJsonString(requestResult);
		}

		Score score = new Score(value, System.currentTimeMillis(), name);
		ServiceLocator.getScoreManagement().addScore(score);

		requestResult.setMessage("Score successfully added!");
		requestResult.setCode(RequestResult.Codes.SUCCESS);
		return GsonHelper.objectToJsonString(requestResult);

	}
}
