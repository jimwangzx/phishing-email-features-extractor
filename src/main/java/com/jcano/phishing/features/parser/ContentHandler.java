package com.jcano.phishing.features.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.parser.AbstractContentHandler;
import org.apache.james.mime4j.stream.BodyDescriptor;
import org.apache.james.mime4j.stream.Field;

import com.jcano.phishing.features.Features;
import com.jcano.phishing.features.utils.Utils;

public class ContentHandler extends AbstractContentHandler {
	
	private Features features = new Features();
	
	
	public void body(BodyDescriptor bd, InputStream is)
            throws MimeException, IOException {
        String bodyStr = new BufferedReader(
        	      new InputStreamReader(is, StandardCharsets.UTF_8))
        	        .lines()
        	        .collect(Collectors.joining("\n"));
        features.setHtmlBody(Utils.hasHTMLTags(bodyStr));
        System.out.println("----------Body Start------------");
        System.out.println(bodyStr);
        System.out.println("----------Body End------------");
    }
	
    public void startHeader() throws MimeException {
    	System.out.println("----------Header Start------------");
    }
    
    public void endHeader() throws MimeException {
    	System.out.println("----------Header End------------");
    }
    
    public void field(Field field) throws MimeException {
    	System.out.println(field.getName());
    	System.out.println("	" + field.getBody());
    }
    
	public Features getFeatures() {
    	return this.features;
    }

}
