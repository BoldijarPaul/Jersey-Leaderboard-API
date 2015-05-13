package com.boldijarpaul.rest.servlets;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.boldijarpaul.rest.entities.RequestResult;
import com.boldijarpaul.rest.entities.Score;
import com.boldijarpaul.rest.helper.GsonHelper;
import com.boldijarpaul.rest.service.ServiceLocator;

@Path("/scores")
public class ScoresServlet {

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public String getScoresJson() {
		List<Score> scores = ServiceLocator.getScoreManagement().getAllScores();
		RequestResult requestResult = new RequestResult("Success",
				RequestResult.Codes.SUCCESS, scores);
		return GsonHelper.objectToJsonString(requestResult);
	}

	@Path("/add")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
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
		requestResult.setData(score);
		return GsonHelper.objectToJsonString(requestResult);

	}

	@GET
	@Path("gettop/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTopScores(@PathParam("param") int count) {
		/* if the number is not valid, show error message */
		if (count < 0) {
			RequestResult requestResult = new RequestResult();
			requestResult
					.setMessage("The number must be positive and greater than 0!");
			requestResult.setCode(RequestResult.Codes.INVALID_VALUE);
			return GsonHelper.objectToJsonString(requestResult);
		}
		/* list the first n scores */
		List<Score> scores = ServiceLocator.getScoreManagement().getTopScores(
				count);
		RequestResult requestResult = new RequestResult("Success",
				RequestResult.Codes.SUCCESS, scores);
		return GsonHelper.objectToJsonString(requestResult);

	}

	@Path("/delete")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteScore(
			@DefaultValue("-1") @QueryParam("value") long value,
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

		int deletedScores = ServiceLocator.getScoreManagement().deleteScores(
				value, name);

		requestResult.setMessage(deletedScores + " scores deleted");
		requestResult.setCode(RequestResult.Codes.SUCCESS);
		requestResult.setData(null);
		return GsonHelper.objectToJsonString(requestResult);

	}
}
