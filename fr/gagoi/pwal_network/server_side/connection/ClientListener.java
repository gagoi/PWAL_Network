package fr.gagoi.pwal_network.server_side.connection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class ClientListener implements Runnable{

	private static final int MAX_PACKET_SIZE = 1024;
	
	private boolean listening;
	private DatagramSocket socket;
	private DatagramPacket packet = new DatagramPacket(new byte[54], MAX_PACKET_SIZE);
	
	public ClientListener(InetAddress address, int port) {
		listening = true;
		try {
			socket = new DatagramSocket(port, address);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public ClientListener(Socket main_socket) {
		this(main_socket.getInetAddress(), main_socket.getLocalPort());
	}

	@Override
	public void run() {
		while (listening) {
			try {
				socket.receive(packet);
				System.out.println(new String(packet.getData()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
