package base;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {

	private int userId;
	private String userName;
	private String userEmail;
	
	/**
	 * Constructor
	 * @param ID
	 * @param name
	 * @param email
	 */
	public User(int userId, String userName, String userEmail){
		// TODO
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	public int getUserId(){
		return userId;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getUserEmail(){
		return userEmail;
	}
	
	public String toString(){
		String user = "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
		return user;
	}
	
	@Override
	public int compareTo(User u){
		if(userId == u.getUserId())
			return 0;
		else if(userId > u.getUserId())
			return 1;
		else return -1;
	}
}
