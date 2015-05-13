package com.boldijarpaul.rest.servlets;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.boldijarpaul.rest.entities.Score;
import com.boldijarpaul.rest.helper.GsonHelper;
import com.boldijarpaul.rest.service.ServiceLocator;

@Path("/scores")
public class ScoresServlet {

	@GET
	@Path("/getall")
	public String getScoresJson(){
		List<Score> scores=ServiceLocator.getScoreManagement().getAllScores();
		return GsonHelper.objectToJsonString(scores);
	}
}
