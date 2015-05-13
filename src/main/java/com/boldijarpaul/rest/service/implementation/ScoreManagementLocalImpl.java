package com.boldijarpaul.rest.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.boldijarpaul.rest.entities.Score;
import com.boldijarpaul.rest.service.interfaces.IScoreManagement;

public class ScoreManagementLocalImpl implements IScoreManagement {

	/* in this demo we are going to create our scores here in the constructor */
	private List<Score> allScores = new ArrayList<Score>();

	public ScoreManagementLocalImpl() {
		/* add 2 random scores */
		for (int i = 1; i <= 2; i++)
			allScores.add(new Score((long) (Math.random() * 1000000), System
					.currentTimeMillis(), "GEORGE" + Math.random()));

	}

	@Override
	public List<Score> getAllScores() {
		return allScores;
	}

	@Override
	public void addScore(Score score) {
		allScores.add(score);
	}

}
