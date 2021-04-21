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
import com.jcano.phishing.features.utils.FeaturesUtils;

public class ContentHandler extends AbstractContentHandler {
	
	private Features features = new Features();
	
    public void startHeader() throws MimeException {
    	//System.out.println("Reading Header...");
    }
    
    public void endHeader() throws MimeException {
    	//System.out.println("Done");
    }
    
    public void field(Field field) throws MimeException {
    	// System.out.println(field.getName());
    	// System.out.println("	" + field.getBody());
    }
	
	public void body(BodyDescriptor bd, InputStream is)
            throws MimeException, IOException {
		//System.out.println("Reading  Body...");
		
        String bodyStr = new BufferedReader(
        	      new InputStreamReader(is, StandardCharsets.UTF_8))
        	        .lines()
        	        .collect(Collectors.joining("\n"));
        features.setHtmlBody(FeaturesUtils.hasHTMLTags(bodyStr));
        features.setAccountTerm(FeaturesUtils.isTerm(FeaturesUtils.ACCOUNT, bodyStr));
        features.setAgreeTerm(FeaturesUtils.isTerm(FeaturesUtils.AGREE, bodyStr));
        features.setDearTeam(FeaturesUtils.isTerm(FeaturesUtils.DEAR, bodyStr));
        features.setDomainsCount(0);
        features.setDotsCount(0);
        features.setHexadecimalURLs(0);
        features.setImagesAsURL(FeaturesUtils.numberOfImageAsURL(bodyStr));
        features.setLoginTerm(FeaturesUtils.isTerm(FeaturesUtils.LOGIN, bodyStr));
        features.setPayPalTerm(FeaturesUtils.isTerm(FeaturesUtils.PAYPAL, bodyStr));
        features.setPhishingTermsWeight(10);
        features.setSuspendTerm(FeaturesUtils.isTerm(FeaturesUtils.SUSPEND, bodyStr));
        features.setVerifyTerm(FeaturesUtils.isTerm(FeaturesUtils.VERIFY, bodyStr));
    }
    
	public Features getFeatures() {
    	return this.features;
    }

}
