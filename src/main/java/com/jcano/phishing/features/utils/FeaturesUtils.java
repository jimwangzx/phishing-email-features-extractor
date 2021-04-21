package com.jcano.phishing.features.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeaturesUtils {
	
	private static final String HTML_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
	
	// Pattern for recognizing a URL, based off RFC 3986
	private static final Pattern URL_PATTERN = Pattern.compile(
		        "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
		                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
		                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
		        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	
	private static final Pattern IP_PATTERN = Pattern.compile("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b");
	
	private static final Pattern URL_IMAGES = Pattern.compile("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)(.jpeg|.jpg|.png|.tif|.tiff|.bmp|.gif|.eps|.raw)");
	
	public static final String ACCOUNT = "account";
	
	public static final String DEAR = "dear";
	
	public static final String PAYPAL = "paypal";
	
	public static final String LOGIN = "login";
	
	public static final String BANK = "bank";
	
	public static final String VERIFY = "verify";
	
	public static final String AGREE = "agree";
	
	public static final String SUSPEND = "suspend";
	
	public static boolean hasHTMLTags(String text){
		Pattern pattern = Pattern.compile(HTML_PATTERN);
	    Matcher matcher = pattern.matcher(text);
	    return matcher.find();
	}
	
	public static boolean hasURL(String text){
	    Matcher matcher = URL_PATTERN.matcher(text);
	    return matcher.find();
	}
	
	public static List<String> getURLs(String text){
		List<String> urls = new ArrayList<String>();
		Matcher matcher = URL_PATTERN.matcher(text);
		while(matcher.find()) {
			urls.add(matcher.group());
		}
		return urls;
	}
	
	public static boolean isTerm(String term, String text){
		String IS_TERM_PATTERN = "\\b" + term.toLowerCase() + "\\b";
		Pattern pattern = Pattern.compile(IS_TERM_PATTERN);
		Matcher matcher = pattern.matcher(text.toLowerCase());
		return matcher.find();
	}
	
	public static int numberOfImageAsURL(String text){
		Matcher matcher = URL_IMAGES.matcher(text.toLowerCase());
		return matcher.results().toArray().length;
	}
		
	public static int numberOfIpUrls(String text){
		Matcher matcher = IP_PATTERN.matcher(text.toLowerCase());
		return matcher.results().toArray().length;
	}

}
