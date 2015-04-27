package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	public static final int PORT = 3021;
	
	public static void main(String[] args) throws IOException{
		try(
			ServerSocket serverSocket = new ServerSocket(PORT);
			Socket clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		) {
			String inputLine;
			while((inputLine = in.readLine()) != null)
					System.out.print(inputLine);
		} catch (IOException e) {
			System.out.println("error");
			System.out.println(e.getMessage());
		}
		
		
	}
}
