package base;

public class User {

	private int ID;
	private String name;
	private String email;
	
	/**
	 * Constructor
	 * @param ID
	 * @param name
	 * @param email
	 */
	public User(int ID, String name, String email){
		// TODO
		this.ID = ID;
		this.name = name;
		this.email = email;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
}
