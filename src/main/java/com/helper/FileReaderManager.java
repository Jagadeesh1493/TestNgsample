package com.helper;

public class FileReaderManager {

	private FileReaderManager() {
		//to restrict the other class to create object 
	}
	
	public static FileReaderManager getInstance() {
		FileReaderManager reader = new FileReaderManager();
		return reader;
	}
	
	
	public ConfigurationReader getInstanceCR() throws Throwable {
		ConfigurationReader reader =new ConfigurationReader();
		return reader;
	}
	
}
