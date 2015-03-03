package base;

import java.util.Date;

public class FriendsPost extends Post{
	
	private User friends;
	
	//TODO
	
	public FriendsPost(Date date, String content, User friends) {
		super(date, content);
		// TODO Auto-generated constructor stub
		this.friends = friends;
	}

	public String toString(){
		//TODO
		String userinfo = "User [userId=" + friends.getID() + ", userName=" + friends.getName() + ", userEmail=" +friends.getEmail() +"]" + "\n" + super.toString();
		return userinfo;
	}

}
