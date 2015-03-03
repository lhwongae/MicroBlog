package blog;

import java.util.ArrayList;

import base.*;

public class Blog {
	
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
	
	
}
