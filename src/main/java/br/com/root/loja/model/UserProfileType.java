package br.com.root.loja.model;

public enum UserProfileType {
	USER("ROLE_USER"),
	DBA("ROLE_DBA"),
	ADMIN("ROLE_ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
