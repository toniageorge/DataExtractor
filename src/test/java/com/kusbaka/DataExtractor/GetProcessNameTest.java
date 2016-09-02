package com.kusbaka.DataExtractor;

import org.junit.*;
import static org.junit.Assert.*;

public class GetProcessNameTest {


	GetProcessName getProcessName;
	@Before
	public void setUp() {

		getProcessName=new GetProcessName();
	}
	@Test
	public void getProcessTestforOmdb(){

		String name="omdb";
		DataProcessor dataSource =getProcessName.getProcess(name);
		Assert.assertTrue(dataSource instanceof OmdbApiData);
	}
	@Test
	public void getProcessTestForSpotify(){

		String name="spotify";
		DataProcessor dataSource =getProcessName.getProcess(name);
		Assert.assertTrue(dataSource instanceof SpotifyApidata);

	}
	@Test
	public void getProcessTestforNull(){

		String name=null;
		DataProcessor dataSource =getProcessName.getProcess(name);
		assertNull(dataSource);
	}

}
