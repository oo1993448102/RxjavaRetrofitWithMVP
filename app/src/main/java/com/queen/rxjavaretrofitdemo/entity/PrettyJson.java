package com.queen.rxjavaretrofitdemo.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class PrettyJson {

	public static String getPretty(String json) {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonStr2 = gson.toJson(je);
		return prettyJsonStr2;
	}

}
