package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler implements Runnable{
	
	private Socket clientSocket;
	private int visitor_count = 0;
	
	public ThreadHandler(Socket soc, int count) {
		clientSocket = soc;
		this.visitor_count = count;
	}

	public void run(){
		try (
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		){
			String inputLine;
			while((inputLine = in.readLine()) != null){
				if(inputLine.equals("visitor")){
					out.println("You're the " + visitor_count + " visitor today");
				}
				else if(inputLine.equals("quit")){
					clientSocket.close();
					out.close();
					in.close();
					break;
				}
				else {
					out.println("echo: " + inputLine);
				}
			}
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
