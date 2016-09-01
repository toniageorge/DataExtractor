package com.kusbaka.DataExtractor;

import java.util.List;

/**
 *main class to call the api to fetch data for music or movie.As per the input,it decides what to fetch
 *
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		String movieName="Life on  road";
		String api="Album";
		
		
		GetProcessName getProcessName=new GetProcessName();
		DataProcessor dataProcessor =getProcessName.getProcess(api);
		List <Movie> data=dataProcessor.processData( movieName);
		if(data.size()!=0){
			for(Movie m: data){

				System.out.println(m.getTitle()+", "+m.getYear()+", "+m.getDirector());

			}
		 }
		else{
			System.out.println("no data Found");

		}


	}
}
