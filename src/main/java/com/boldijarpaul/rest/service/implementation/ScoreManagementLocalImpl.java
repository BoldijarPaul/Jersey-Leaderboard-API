package com.boldijarpaul.rest.service.implementation;

import java.util.ArrayList;
import java.util.Collections;
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
		Collections.sort(allScores);
	}

	@Override
	public List<Score> getTopScores(int count) {
		// TODO Auto-generated method stub
		return allScores.subList(0, Math.min(count, allScores.size()));
	}

	@Override
	public int deleteScores(long value, String name) {
		// TODO Auto-generated method stub
		int deleted = 0;
		for (int i = 0; i < allScores.size(); i++) {
			if (allScores.get(i).getValue() == value
					&& allScores.get(i).getUsername().equals(name)) {
				/* we found a score that we want to delete */
				deleted++;
				allScores.remove(i--);
			}
		}
		return deleted;
	}

}
