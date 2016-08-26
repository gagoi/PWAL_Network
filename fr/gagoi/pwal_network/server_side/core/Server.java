package fr.gagoi.pwal_network.server_side.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import fr.gagoi.pwal_network.server_side.connection.Client;

public class Server implements Runnable {

	private boolean isOpen;
	private ServerSocket main_socket;
	
	private Vector<Client> clients = new Vector<>();
	
	public static final String REQUEST_CODE_CONNECTION = "0_";
	public static final String REQUEST_CODE_GAME = "1_";
	public static final String REQUEST_CODE_CHAT = "2_";
	public static final String REQUEST_CODE_LOGIN = "3_";

	public Server(int port) {
		this.isOpen = true;
		try {
			this.main_socket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (isOpen) {
			Socket client_socket;
			try {
				if ((client_socket = main_socket.accept()) != null) clients.addElement(new Client(client_socket));
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
		
	}

}
