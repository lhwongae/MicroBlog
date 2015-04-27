package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BlogClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args) throws IOException{
		try(
			Socket socket = new Socket(IP, PORT);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
		) {
			String post = "hi";
			out.println(post);
		} catch(UnknownHostException e) {
			System.err.println("Don't know about host " + IP);
			System.exit(1);
		} catch(IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + IP);
			System.exit(1);
		}
		
	}
}
