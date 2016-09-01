package com.kusbaka.DataExtractor;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ProcessAlbumdata implements DataProcessor {


	public List<Movie> processData( String albumName){

		if(albumName==null){

			return null;
		}

		String Query1 = Constant.QueryForAlbum+albumName+Constant.typeforAlbum;
		String albumDetails = HttpHandler.getResponse(Query1);
		List<Movie> mylist =new ArrayList<Movie>();
		JsonParser parser = new JsonParser();

		JsonObject jsonObject = (JsonObject) parser.parse(albumDetails).getAsJsonObject();
		if(jsonObject!=null){
			JsonObject innerObject = jsonObject.getAsJsonObject(Constant.albums);

			JsonArray jsonArray = innerObject.getAsJsonArray(Constant.items);
			
				for (int i = 0, size = jsonArray.size(); i < size; i++){

					String albumTitle=jsonArray.get(i).getAsJsonObject().get(Constant.albumTitle).getAsString();
					String href=jsonArray.get(i).getAsJsonObject().get(Constant.QuerytofetchArtist).getAsString();
					String ArtistNames = HttpHandler.getResponse(href);
					JsonObject artistobj = (JsonObject) parser.parse(ArtistNames).getAsJsonObject();
					JsonArray artistdetails = artistobj.getAsJsonArray(Constant.artists);
					String artist=artistdetails.get(0).getAsJsonObject().get(Constant.artistName).getAsString();
					String date=artistobj.get(Constant.releaseDate).getAsString();
					Movie m=new Movie();
					m.setTitle(albumTitle);
					m.setYear(date);
					m.setDirector(artist);
					mylist.add(m);


				}
			}
		
		


		return mylist;
	}


}
