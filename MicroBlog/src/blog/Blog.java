package blog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import base.*;

public class Blog implements Serializable{
	
	/**
	 * Constructor
	 * @param user
	 */
	private User user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user){
		//TODO
		allPosts = new ArrayList<Post>();
		this.user = user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user){
		//TODO
		this.user = user;
	}
	
	/**
	 * 
	 * @return
	 */
	public User getUser(){
		//TODO
		return user;
	}
	
	/**
	 * create a new post in your blog
	 * @param post
	 */
	public void post(Post p){
		//TODO add Post p to your blog
		allPosts.add(p);
		
		//TODO print a message if succeed
		System.out.println("A new Post: \n" + p);
	}
	
	/**
	 * list all posts in the blog
	 * 
	 */
	public void list(){
		//TODO
		System.out.print("Current posts: \n" + toString());
	}
	
	/**
	 * delete a post from the blog
	 * @param index
	 */
	public void delete(int index){
		//Is the legal? The index should be neither too high nor negative.
		//If the index is legal, delete the corresponding Post
		//Otherwise print a fault message.
		if(index-1 < allPosts.size() && index > 0){
			allPosts.remove(index-1);
		}
		else System.out.println("Illegal deletion");
	}
	
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 */
	public String toString(){
		//TODO
		String printblog = "";
		for(int i = 0; i < allPosts.size(); i++){
			int numOfPost = i + 1; 
			printblog = printblog + "Post[" + numOfPost + "]:" + allPosts.get(i) + "\n";
		}
		return printblog;
	}
	
	@Override
	/**
	 * Check whether this object equals object o
	 * @param object o
	 * @return Boolean
	 */
	public boolean equals(Object o){
		//TODO
		boolean ans = true;

		if(o == null)
			ans = false;

		o.getClass();
		
		Blog blog = (Blog) o;
		
		if(blog.getUser() != this.user || blog.allPosts != this.allPosts)
			ans = false;
		
		return ans;
	}
	
	@Override
	/**
	 * 
	 * @return
	 */
	public int hashCode(){
		int hashCode = 0;
		//TODO
		
		hashCode = user.hashCode() + allPosts.hashCode();
		
		return hashCode;
	}
	
	public void search(int month, String someone) {
		
		Calendar cal = Calendar.getInstance();
		for(Post p : allPosts) {
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			if(postMonth+1 == month && p.contains("@"+someone)){
				System.out.print(p);
			}
		}
	}

	public void setPosts(ArrayList<Post> allPosts) {
		// TODO Auto-generated method stub
		this.allPosts = allPosts;
	}
	
	public void save(String filepath){
		try{
			FileOutputStream fs = new FileOutputStream(filepath);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void load(String filepath){
		try{
			FileInputStream fs = new FileInputStream(filepath);
			ObjectInputStream is = new ObjectInputStream(fs);
			Blog temp = (Blog) is.readObject();
			setUser(temp.getUser());
			setPosts(temp.allPosts);
			is.close();
			
		} catch(FileNotFoundException e){
			System.out.print("Wait! There is something wrong. I cannot find the file..");
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
