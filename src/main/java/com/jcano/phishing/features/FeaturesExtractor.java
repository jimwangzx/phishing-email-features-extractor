package com.jcano.phishing.features;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jcano.phishing.features.parser.EmailParser;

/**
 * Phishing email classifier
 * Features extractor
 *
 */
public class FeaturesExtractor {
	
	private static Properties properties =  new Properties();
	private static String phishingCollectionPath = "";
	private static String hamColllectionPath = "";
	
    private static void  loadConfiguration () throws IOException  {
    	InputStream inputStream = FeaturesExtractor.class.getClassLoader().getResourceAsStream("config.properties");
    	properties.load(inputStream);
    	phishingCollectionPath = properties.getProperty("phishing.email.collection.path");
		hamColllectionPath = properties.getProperty("ham.email.collection.path");
    }
	
	public static void main( String[] args ) {
		try {
			loadConfiguration();
			
			// EmailParser phishingEmailParser = new EmailParser(phishingCollectionPath);
			// phishingEmailParser.getEmailFeaturesCollection();
			
			EmailParser hamEmailParser = new EmailParser();
			Features features = hamEmailParser.getEmailFeatures(hamColllectionPath);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}