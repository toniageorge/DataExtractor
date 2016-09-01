package com.kusbaka.DataExtractor;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ProcessMovieData implements DataProcessor {



	public  List<Movie> processData(String movieName){

		if(movieName==null){

			return null;
		}

		String imdbQuery1 =Constant.QueryForYear+movieName+Constant.type;


		String movieNames = HttpHandler.getResponse(imdbQuery1);

		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(movieNames).getAsJsonObject();

		List<Movie> mylist =new ArrayList<Movie>();
		if(jsonObject.getAsJsonArray(Constant.search)!=null){

			for(int i = 0; i < jsonObject.getAsJsonArray(Constant.search).size(); i++){
				JsonObject jsonData=jsonObject.getAsJsonArray(Constant.search).get(i).getAsJsonObject();
				String title=jsonData.get(Constant.title).getAsString();
				String year=jsonData.get(Constant.year).getAsString();
				String imdbQuery2 = Constant.QueryForDirector+movieName+Constant.queryStringYear+year+Constant.type;
				String directorName = HttpHandler.getResponse(imdbQuery2);
				JsonObject jsonObjectDirector = (JsonObject) parser.parse(directorName).getAsJsonObject(); 
				String director=jsonObjectDirector.get(Constant.director).getAsString();
				Movie m=new Movie();
				m.setTitle(title);
				m.setYear(year);
				m.setDirector(director);
				mylist.add(m);


			}
		}
		
		return mylist;
	}


}
