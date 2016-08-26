package fr.gagoi.pwal_network.server_side.connection;

import java.net.Socket;

public class Client {

	private ClientListener listener;

	public Client(Socket main_socket) {
		listener = new ClientListener(main_socket);
	}
	
}
