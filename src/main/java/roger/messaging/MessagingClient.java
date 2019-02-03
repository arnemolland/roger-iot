package roger.messaging;

import java.io.IOException;
import java.net.Socket;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() {

		Socket clientSocket = null;

		// TODO
		// create TCP socket for client and connection
		try {
			clientSocket = new Socket(server, port);
		} catch (IOException ex) {
			System.out.println("Messaging layer: Connection error.");
			return null;
		}

		return new Connection(clientSocket);
	}
}
