package com.kusbaka.DataExtractor;
/**
 *This is a factory class which is having a method named getProcess that returns the object based on the name
 *
 */
public class GetProcessName {

	
	public DataProcessor getProcess(String name){
		if(name==null){
			
			return null;
		}
		
		if(name.equalsIgnoreCase(Constant.OMDB)){
			
			return new OmdbApiData();
		}
      if(name.equalsIgnoreCase(Constant.SPOTIFY)){
			
			return new SpotifyApidata();
		}
      
		return null;
	}
}
