package roger.rpc;

import roger.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;

	public RPCClient(String server, int port) {
		msgclient = new MessagingClient(server, port);
	}

	public void register(RPCStub remote) {
		remote.register(this);
	}

	public void connect() {
		if (connection == null) {
			try {
				connection = msgclient.connect();
			} catch (Exception e) {
				System.out.println("An error occured: " + e.getMessage());
			}
		}
	}

	public void disconnect() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public byte[] call(byte[] rpcrequest) {

		Message message = new Message(rpcrequest);

		connection.send(message);

		Message received = connection.receive();
		
		/*
		 *  
		 * Make a remote call on the RPC server by sending a request message and receive
		 * a reply message
		 * 
		 * rpcrequest is the marshalled rpcrequest from the client-stub rpctreply is the
		 * rpcreply to be unmarshalled by the client-stub
		 * 
		 */

		return received.getData();
	}
}
