package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer{
	
	public static final int PORT = 3021;
	public static int count = 0;
	
	public static void main (String[] args) throws IOException{
		
		ServerSocket svrSocket = new ServerSocket(PORT);
		
		Socket clientSocket = null;

		while (true) {

			clientSocket = svrSocket.accept();
			count++;
			ThreadHandler handler = new ThreadHandler(clientSocket,count);
			handler.run();
			
		}
	}
}
