package com.boldijarpaul.rest.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {

	private static Gson gson=new GsonBuilder().setPrettyPrinting().create();
	public static String objectToJsonString(Object object){
		return gson.toJson(object);
	}
}
