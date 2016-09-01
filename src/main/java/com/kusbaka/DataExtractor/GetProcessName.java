package com.kusbaka.DataExtractor;

public class GetProcessName {

	
	public DataProcessor getProcess(String name){
		if(name==null){
			
			return null;
		}
		
		if(name.equalsIgnoreCase("Movie")){
			
			return new ProcessMovieData();
		}
      if(name.equalsIgnoreCase("Album")){
			
			return new ProcessAlbumdata();
		}
		
		return null;
	}
}
