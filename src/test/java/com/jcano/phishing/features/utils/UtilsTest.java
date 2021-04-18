package com.jcano.phishing.features.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class UtilsTest {

    @Test
    public void validateHasHTMLTags(){
    	Assert.assertFalse(Utils.hasHTMLTags("Hi, how are you today Regards \n"));
    	Assert.assertTrue(Utils.hasHTMLTags("Hi, how are you today Regards <script>alert('Hei')</script>"));
    	Assert.assertTrue(Utils.hasHTMLTags("Hi, how are you today </br> Regards"));
    	Assert.assertTrue(Utils.hasHTMLTags("Hi, how are you today <customTag> Regards"));
    }
    
    @Test
    public void validateHasURLs(){	
    	List<String> result = Utils.getURLs("Hi, "
    			+ "how are you today? "
    			+ "This are the links: "
    			+ "1.- http://10.15.22.2:8080/link1 "
    			+ "2.- https://10.15.22.2/link2 "
    			+ "3.- https://domain.com/link2 "
    			+ "4.- https://ivalidDomain/link2");
    	List<String> expected = new ArrayList<String>();
    	expected.add(" http://10.15.22.2:8080/link1");
    	expected.add(" https://10.15.22.2/link2");
    	expected.add(" https://domain.com/link2");
    	
    	Assert.assertArrayEquals(result.toArray(), expected.toArray());
    }
    
    @Test
    public void isAccountTerm(){
    	String textWithAccount = "Please, add your ._ AcCount. number";
    	String textWithoutAccount = "He emphasized that accountability is not only about supply but also about demand.";
    	Assert.assertTrue(Utils.isTerm(Utils.ACCOUNT, textWithAccount));
    	Assert.assertFalse(Utils.isTerm(Utils.ACCOUNT, textWithoutAccount));
    }
    
    @Test
    public void isDearTerm(){
    	String textWithDear = "Dear customer";
    	String textWithoutDear = "Deardrops is the name of the band";
    	Assert.assertTrue(Utils.isTerm(Utils.DEAR, textWithDear));
    	Assert.assertFalse(Utils.isTerm(Utils.DEAR, textWithoutDear));
    }
    
    @Test
    public void isPaypalTerm(){
    	String textWithPaypal = "Please, introduce your paypal credentials";
    	String textWithoutPaypal = "Just for testing purpose";
    	Assert.assertTrue(Utils.isTerm(Utils.PAYPAL, textWithPaypal));
    	Assert.assertFalse(Utils.isTerm(Utils.PAYPAL, textWithoutPaypal));
    }
    
    @Test
    public void isLoginTerm(){
    	String textWithLogin = "Please, access to login page";
    	String textWithoutLogin = "Just for testing purpose";
    	Assert.assertTrue(Utils.isTerm(Utils.LOGIN, textWithLogin));
    	Assert.assertFalse(Utils.isTerm(Utils.LOGIN, textWithoutLogin));
    }
    
    @Test
    public void isBankTerm(){
    	String textWithBank = "Please, access to your bank website";
    	String textWithoutBank = "Just for testing purpose";
    	Assert.assertTrue(Utils.isTerm(Utils.BANK, textWithBank));
    	Assert.assertFalse(Utils.isTerm(Utils.BANK, textWithoutBank));
    }
	
    @Test
    public void isVerifyTerm(){
    	String textWithVerify = "Please verify your acces credentials";
    	String textWithoutVerify = "Just for testing purpose";
    	Assert.assertTrue(Utils.isTerm(Utils.VERIFY, textWithVerify));
    	Assert.assertFalse(Utils.isTerm(Utils.VERIFY, textWithoutVerify));
    }
	
    @Test
    public void isAgreeTerm(){
    	String textWithAgree = "Do you agree with the new condition terms?";
    	String textWithoutAgree = "Just for testing purpose";
    	Assert.assertTrue(Utils.isTerm(Utils.AGREE, textWithAgree));
    	Assert.assertFalse(Utils.isTerm(Utils.AGREE, textWithoutAgree));
    }
	
    @Test
    public void isSuspendTerm(){
    	String textWithSuspend = "Unfortunately we are going to suspend your account";
    	String textWithoutSuspend = "Just for testing purpose";
    	Assert.assertTrue(Utils.isTerm(Utils.SUSPEND, textWithSuspend));
    	Assert.assertFalse(Utils.isTerm(Utils.SUSPEND, textWithoutSuspend));
    }
    
    @Test
    public void numberOfIpsURLs(){
    	String text = "http://123.168.10.1/ \n" + 
    			"http://123.168.10.2/ \n" + 
    			"http://123.168.10.3/";
    	Assert.assertEquals(Utils.numberOfIpUrls(text), 3);
    }
    
    @Test
    public void numberOfImagesAsURL(){
    	String text = "https://s1.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.png \n" + 
    			"http://s2.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.jpeg \n" + 
    			"http://s3.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.jpg \n" + 
    			"http://s4.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.pdf";
    	Assert.assertEquals(Utils.numberOfImageAsURL(text), 3);
    }

}
