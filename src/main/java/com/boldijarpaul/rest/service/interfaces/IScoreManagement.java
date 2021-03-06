package com.boldijarpaul.rest.service.interfaces;

import java.util.List;

import com.boldijarpaul.rest.entities.*;

/**
 * 
 * Returns all the scores.
 *
 */
public interface IScoreManagement {
	public List<Score> getAllScores();

	public List<Score> getTopScores(int count);

	public void addScore(Score score);

	public int deleteScores(long value, String name);
}
