package com.boldijarpaul.rest.service;

import com.boldijarpaul.rest.service.implementation.ScoreManagementLocalImpl;
import com.boldijarpaul.rest.service.interfaces.IScoreManagement;

public class ServiceLocator {

	/* singleton for the score management */
	private static IScoreManagement scoreManagement;
	public static IScoreManagement getScoreManagement() {
		if(scoreManagement==null){
			scoreManagement=new ScoreManagementLocalImpl();
		}
		return scoreManagement;
	}
}
