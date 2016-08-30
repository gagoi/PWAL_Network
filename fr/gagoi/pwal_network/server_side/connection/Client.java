package fr.gagoi.pwal_network.server_side.connection;

import java.net.Socket;

public class Client {

	public static final int STATE_CONNECTED = 0;
	public static final int STATE_LOGGED = 1;
	public static final int STATE_CREATE_GAME = 2;
	public static final int STATE_QUEUE = 3;
	public static final int STATE_CHARACTER_SELECTION = 4;
	public static final int STATE_IN_GAME = 5;
	
	private ClientListener listener;
	private Thread listener_thread;
	
	private int state = STATE_LOGGED;
	
	public Client(Socket main_socket) {
		listener = new ClientListener(main_socket);
		listener_thread = new Thread(listener);
		listener_thread.start();
	}
	
}
