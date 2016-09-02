package com.kusbaka.DataExtractor;

import java.util.List;

/**
 *main class to call the api to fetch data for music or movie.As per the input,it decides from which api data has to fetch
 *Once the data is fetched it prints title,year and director.
 *
 */
public class App 
{
	public static void main( String[] args )
	{

		String api=System.getProperty("api");
		String movieName=System.getProperty("name");

		GetProcessName getProcessName=new GetProcessName();
		DataProcessor dataProcessor =getProcessName.getProcess(api);
		if(dataProcessor!=null){
			List <Movie> data=dataProcessor.processData( movieName);
			if(data.size()!=0){
				for(Movie m: data){

					System.out.println(m.getTitle()+", "+m.getYear()+", "+m.getDirector());

				}
			}
			else{
				System.out.println(Constant.NoDataFound);

			}
		}
		else{

			System.out.println(Constant.errorMessage);
		}

	}
}
