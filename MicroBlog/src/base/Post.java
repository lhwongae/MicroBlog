package base;
import java.io.Serializable;
import java.util.Date;


public class Post implements Comparable<Post>, Serializable {
	
	private Date date;
	private String content;
	
	/**
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content){
		// TODO
		this.date = date;
		this.content = content;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	/**
	 * 
	 * @return the content of the blog
	 */
	
	public String getContent(){
		//TODO
		return content;
	}
	
	/**
	 * 
	 * @param content
	 */
	
	public void setContent(String content){
		//TODO
		this.content = content;
	}
	
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 * 
	 */
	public String toString(){
		//TODO
		String dateandcontent = date.toString() + "\n" + content;
		return dateandcontent;
	}
	
	@Override
	/**
	 * Check whether this object equals object o
	 * @param object o
	 * @return Boolean
	 * 
	 */
	public boolean equals(Object o){
		
		boolean ans = true;
		// Should it be equal compared to itself?
		
		// What if if object is null?
		if(o == null)
			ans = false;
		// Are they the same class?
		// You can get the class of object o
		o.getClass();
		
		// You can transfer object o to POST
		Post post = (Post) o;
		
		// In what circumstance will you think that post A is equal to post B?
		if(post.getContent() != this.content || post.date != this.date)
			ans = false;
		
		return ans;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		int hashCode = 0;
		//TODO
		//You should give hashCode a unique value?
		//You can use the hashCode of your attributes
		
		hashCode = date.hashCode() + content.hashCode();
		
		return hashCode;
		
	}
	
	/**
	 * check whether this post contains some keyword
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword){
		
		//TODO
		
		String[] splitcontent = content.split(" ");
		for(int i = 0; i<splitcontent.length; i++){
			if(splitcontent[i].equals(keyword))
				return true;
		}
		return false;
	}
	
	public int compareTo(Post p){
		if(date == p.date)
			return 0;
		else if(date.after(p.date))
			return 1;
		else return -1;
	}
}
