package com.jcano.phishing.features;

public class Features {
	
	/**
	 * Checks if the email body contains HTML content.
	 */
	private boolean htmlBody;
	
	/**
	 * The number of URLs consisting of hexadecimal characters in the email.
	 */
	private int hexadecimalURLs;
	
	/**
	 * The number of domains in the URLs that exists in the email.
	 */
	private int domainsCount;
	
	/**
	 * The number of URLs whose label is different from its anchor in the email.
	 */
	private int textLinkDifference;
	
	/**
	 * The maximum number of dots that exist in a URL in the email.
	 */
	private int dotsCount;
	
	/**
	 * Checks if the email contains the term “Account”
	 */
	private boolean isAccountTerm;
	
	/**
	 * Checks if the email contains the term “Dear”
	 */
	private boolean isDearTeam;
	
	/**
	 * The number of image URLs.
	 */
	private int imagesAsURL;
	
	/**
	 * The number of URLs whose domain is specified as an IP address.
	 */
	private int ipUrls;
	
	/**
	 * Checks if the email contains the term “PayPal”
	 */
	private boolean isPayPalTerm;
	
	/**
	 * Checks if the email contains the term “Login”
	 */
	private boolean isLoginTerm;
	
	/**
	 * Checks if the email contains the term “Bank”
	 */
	private boolean isBankTerm;
	
	
	/**
	 * Checks if the email contains the term “Verify”
	 */
	private boolean isVerifyTerm;
	
	/**
	 * Checks if the email contains the term “Agree”
	 */
	private boolean isAgreeTerm;
	
	/**
	 * Checks if the email contains the term “Suspend”
	 */
	private boolean isSuspendTerm;
	
	/**
	 * A weight that is assigned to each email and represents
	 * the sum of weights of the phishing terms that exists in that email
	 */
	private int phishingTermsWeight;

	public boolean isHtmlBody() {
		return htmlBody;
	}

	public void setHtmlBody(boolean htmlBody) {
		this.htmlBody = htmlBody;
	}

	public int getHexadecimalURLs() {
		return hexadecimalURLs;
	}

	public void setHexadecimalURLs(int hexadecimalURLs) {
		this.hexadecimalURLs = hexadecimalURLs;
	}

	public int getDomainsCount() {
		return domainsCount;
	}

	public void setDomainsCount(int domainsCount) {
		this.domainsCount = domainsCount;
	}

	public int getTextLinkDifference() {
		return textLinkDifference;
	}

	public void setTextLinkDifference(int textLinkDifference) {
		this.textLinkDifference = textLinkDifference;
	}

	public int getDotsCount() {
		return dotsCount;
	}

	public void setDotsCount(int dotsCount) {
		this.dotsCount = dotsCount;
	}

	public boolean isAccountTerm() {
		return isAccountTerm;
	}

	public void setAccountTerm(boolean isAccountTerm) {
		this.isAccountTerm = isAccountTerm;
	}

	public boolean isDearTeam() {
		return isDearTeam;
	}

	public void setDearTeam(boolean isDearTeam) {
		this.isDearTeam = isDearTeam;
	}

	public int getImagesAsURL() {
		return imagesAsURL;
	}

	public void setImagesAsURL(int imagesAsURL) {
		this.imagesAsURL = imagesAsURL;
	}

	public int getIpUrls() {
		return ipUrls;
	}

	public void setIpUrls(int ipUrls) {
		this.ipUrls = ipUrls;
	}

	public boolean isPayPalTerm() {
		return isPayPalTerm;
	}

	public void setPayPalTerm(boolean isPayPalTerm) {
		this.isPayPalTerm = isPayPalTerm;
	}

	public boolean isLoginTerm() {
		return isLoginTerm;
	}

	public void setLoginTerm(boolean isLoginTerm) {
		this.isLoginTerm = isLoginTerm;
	}

	public boolean isBankTerm() {
		return isBankTerm;
	}

	public void setBankTerm(boolean isBankTerm) {
		this.isBankTerm = isBankTerm;
	}

	public boolean isVerifyTerm() {
		return isVerifyTerm;
	}

	public void setVerifyTerm(boolean isVerifyTerm) {
		this.isVerifyTerm = isVerifyTerm;
	}

	public boolean isAgreeTerm() {
		return isAgreeTerm;
	}

	public void setAgreeTerm(boolean isAgreeTerm) {
		this.isAgreeTerm = isAgreeTerm;
	}

	public boolean isSuspendTerm() {
		return isSuspendTerm;
	}

	public void setSuspendTerm(boolean isSuspendTerm) {
		this.isSuspendTerm = isSuspendTerm;
	}

	public int getPhishingTermsWeight() {
		return phishingTermsWeight;
	}

	public void setPhishingTermsWeight(int phishingTermsWeight) {
		this.phishingTermsWeight = phishingTermsWeight;
	}
	

}
