package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BlogClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args) throws IOException{
		try(
			Socket socket = new Socket(IP, PORT);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		) {
			String userInput;
			while((userInput = strIn.readLine()) != null){
				out.println(userInput);
				
				if(userInput.equals("quit")) {
					break;
				} else {
					System.out.println(in.readLine());
				}
			}
			socket.close();
			out.close();
			in.close();
		} catch(UnknownHostException e) {
			System.err.println("Don't know about host " + IP);
			System.exit(1);
		} catch(IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + IP);
			System.exit(1);
		}
		
	}
}
