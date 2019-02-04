package roger.messaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessagingServer {

	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {
		try {
			this.welcomeSocket = new ServerSocket(port);
		} catch (IOException ex) {
			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * Accept an incoming connection from a client
	 * @return connection
	 */ 
	public Connection accept() {

		Connection connection;
		Socket socket;

		try {
			socket = welcomeSocket.accept();
			connection = new Connection(socket);

			return connection;
		} catch (IOException ex) {
			System.out.println("Connection Error: " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Stop the connection
	 */
	public void stop() {
		if (welcomeSocket != null) {
			try {
				welcomeSocket.close();
			} catch (IOException ex) {
				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
}
