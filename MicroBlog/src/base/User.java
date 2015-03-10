package base;

public class User implements Comparable<User> {

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
	
	public int getID(){
		return userId;
	}
	
	public String getName(){
		return userName;
	}
	
	public String getEmail(){
		return userEmail;
	}
	
	public String toString(){
		String user = "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
		return user;
	}
	
	@Override
	public int compareTo(User u){
		if(userId == u.getID())
			return 0;
		else if(userId > u.getID())
			return 1;
		else return -1;
	}
}
